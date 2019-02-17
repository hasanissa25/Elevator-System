package sysc3303.group2.elevatorsystem.scheduler;

import java.net.SocketException;
import java.net.UnknownHostException;
/*	
 * Author: Hasan Issa
 * Contributors:
 * This schedules the events and floor requests and elevator requests and ensures safety of the entire system
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.ElevatorState;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;

public class Scheduler implements Runnable {

	private static final int DEFAULT_HOST_PORT = 5000;

	private SchedulerHost schedulerHost;
	private Map<Integer, ElevatorState> elevatorStateMap;
	private Map<Integer, Integer> floorAtElevatorMap;
	private boolean isCurrentlyProcessing;
	private Queue<ServiceRequest> serviceRequestQueue;
	private Map<Integer, ServiceRequest> elevatorServiceRequestMap;
	private boolean terminateCommand;

	public Scheduler() throws SocketException, UnknownHostException {
		this(DEFAULT_HOST_PORT);
	}

	public Scheduler(int schedulerPort) throws SocketException, UnknownHostException {
		schedulerHost = new SchedulerHost(schedulerPort);
		elevatorStateMap = new HashMap<>();
		floorAtElevatorMap = new HashMap<>();
		serviceRequestQueue = new LinkedList<ServiceRequest>();
		elevatorServiceRequestMap = new HashMap<>();
		terminateCommand = false;

		// TODO: remove hard code later
		registerElevator(1);
	}

	@Override
	public void run() {
		while (!terminateCommand) {
			try {
				Message m = schedulerHost.waitForANetworkRequest();
				if (m == null)
					continue;
				System.out.println("Scheduler: Processing request: " + m);
				switch (m.getRequestType()) {
				case floorButtonDown:
					processFloorButtonRequest(Direction.DOWN, m.getParameters().get(0));
					break;
				case floorButtonUp:
					processFloorButtonRequest(Direction.UP, m.getParameters().get(0));
					break;
				case arrivalSensorData:
					processArrivalSensorData(m.getParameters());
					break;
				case registerElevator:
					registerElevator(m.getParameters().get(0));
					break;
				case elevatorButtonRequest:
//TODO: implement 
					break;
				default:
					break;
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}

		this.schedulerHost.shutdown();
	}

	private void registerElevator(Integer elevatorNumber) {
		elevatorStateMap.put(elevatorNumber, ElevatorState.ELEVATOR_READY);
		floorAtElevatorMap.put(elevatorNumber, 1);
	}

	private void processArrivalSensorData(List<Integer> parameters) {
		if (parameters.size() <= 3) {
			int elevatorNumber = parameters.get(0);
			int floorCurrentlyAt = parameters.get(1);
			ElevatorState elevatorState = ElevatorState.getByid(parameters.get(2));
			elevatorStateMap.put(elevatorNumber, elevatorState);
			floorAtElevatorMap.put(elevatorNumber, floorCurrentlyAt);
			// TODO: remove hard codes
			if (elevatorServiceRequestMap.get(1).getFloor() == floorAtElevatorMap.get(1)) {
				schedulerHost.sendCommandToElevator(RequestType.moveMotorIdle);
			}
		} else {
			System.err.println(
					"Insufficient number of parameters passed to Scheduler for processing arrival sensor data");
		}
	}

	private void processFloorButtonRequest(Direction direction, int floorNumberThatPressedButton) {
		// serviceRequestQueue.add(new ServiceRequest(direction,
		// floorNumberThatPressedButton));
		// TODO: remove hard codes
		int elevatorAt = floorAtElevatorMap.get(0);

		elevatorServiceRequestMap.put(1, new ServiceRequest(direction, floorNumberThatPressedButton));

		int temp = elevatorAt - floorNumberThatPressedButton;

		if (temp < 0)
			schedulerHost.sendCommandToElevator(RequestType.moveMotorUp);
		else if (temp > 0)
			schedulerHost.sendCommandToElevator(RequestType.moveMotorDown);
		else { // the elevator is already at the floor

		}

	}

	public static void main(String[] args) throws SocketException, UnknownHostException {
		Scheduler s = new Scheduler();
		s.run();
	}

	public boolean isCurrentlyProcessing() {
		return isCurrentlyProcessing;
	}

	public void setCurrentlyProcessing(boolean isCurrentlyProcessing) {
		this.isCurrentlyProcessing = isCurrentlyProcessing;
	}

	public void shutdown() {
		this.terminateCommand = true;
		this.schedulerHost.shutdown();
	}

}
