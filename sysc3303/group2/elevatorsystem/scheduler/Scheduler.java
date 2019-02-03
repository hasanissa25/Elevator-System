package sysc3303.group2.elevatorsystem.scheduler;

/*	
 * Author: Hasan Issa
 * Contributors:
 * This schedules the events and floor requests and elevator requests and ensures safety of the entire system
 */
import java.util.*;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Scheduler implements Runnable {

	private static final int DEFAULT_HOST_PORT = 5000;

	private SchedulerHost schedulerHost;
	private Map<Integer, ElevatorState> elevatorStateMap;
	private Map<Integer, Integer> floorAtElevatorMap;
	private boolean isCurrentlyProcessing;
	private Queue<ServiceRequest> serviceRequestQueue;

	public Scheduler() throws SocketException {
		schedulerHost = new SchedulerHost(DEFAULT_HOST_PORT);
		elevatorStateMap = new HashMap<>();
		floorAtElevatorMap = new HashMap<>();
		serviceRequestQueue = new LinkedList<ServiceRequest>();
	}

	public Scheduler(int schedulerPort) throws SocketException {
		schedulerHost = new SchedulerHost(schedulerPort);
	}

	@Override
	public void run() {
		while (true) {
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
			case elevatorDoorClose:
				break;
			case elevatorDoorOpen:
				break;
			case moveMotorDown:
				break;
			case moveMotorIdle:
				break;
			case moveMotorUp:
				break;
			case registerElevator:
				registerElevator(m.getParameters().get(0));
				break;
			default:
				break;
			}
		}
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
		} else {
			System.err.println(
					"Insufficient number of parameters passed to Scheduler for processing arrival sensor data");
		}
	}

	private void processFloorButtonRequest(Direction direction, int floorNumberThatPressedButton) {
		// serviceRequestQueue.add(new ServiceRequest(direction,
		// floorNumberThatPressedButton));
		if (direction == Direction.UP)
			schedulerHost.sendCommandToElevator(RequestType.moveMotorUp);
		else
			schedulerHost.sendCommandToElevator(RequestType.moveMotorDown);
	}

	public static void main(String[] args) throws SocketException {
		Scheduler s = new Scheduler();
		s.run();
	}

	public boolean isCurrentlyProcessing() {
		return isCurrentlyProcessing;
	}

	public void setCurrentlyProcessing(boolean isCurrentlyProcessing) {
		this.isCurrentlyProcessing = isCurrentlyProcessing;
	}

}
