package sysc3303.group2.elevatorsystem.scheduler;

/*	
 * Author: Hasan Issa
 * Contributors:
 * This schedules the events and floor requests and elevator requests and ensures safety of the entire system
 */
import java.util.*;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.ElevatorState;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Scheduler implements Runnable {

	private static final int DEFAULT_HOST_PORT = 8999;

	private SchedulerHost schedulerHost;
	private Map<Integer, ElevatorState> elevatorStateMap;
	private Map<Integer, Integer> floorAtElevatorMap;
	private boolean isCurrentlyProcessing;
	private Queue<ServiceRequest> serviceRequestQueue;
	private Map<Integer, ArrayList<ServiceRequest>> elevatorServiceRequestMap;
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
				processElevatorButtonRequest(m.getParameters().get(0), m.getParameters().get(1));
				break;
			default:
				break;
			}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Scheduler Shutting Down!");
		this.schedulerHost.shutdown();
	}

	private void processElevatorButtonRequest(Integer floorNumber, int elevatorNumber) {
		if(this.elevatorServiceRequestMap.containsKey(elevatorNumber)) {
			this.elevatorServiceRequestMap.get(elevatorNumber).add(new ServiceRequest(Direction.IDLE, floorNumber));
		}
	}
	
	private void registerElevator(Integer elevatorNumber) {
		elevatorStateMap.put(elevatorNumber, ElevatorState.ELEVATOR_READY);
		floorAtElevatorMap.put(elevatorNumber, 1);
		elevatorServiceRequestMap.put(elevatorNumber, new ArrayList<>());
		
	}

	private void processArrivalSensorData(List<Integer> parameters) {
		if (parameters.size() <= 3) {
			int elevatorNumber = parameters.get(0);
			int floorCurrentlyAt = parameters.get(1);
			ElevatorState elevatorState = ElevatorState.getByid(parameters.get(2));
			elevatorStateMap.put(elevatorNumber, elevatorState);
			floorAtElevatorMap.put(elevatorNumber, floorCurrentlyAt);
			
			for(ServiceRequest request:elevatorServiceRequestMap.get(elevatorNumber)) {
				if(request.getFloor() == floorAtElevatorMap.get(elevatorNumber)) {
					schedulerHost.sendCommandToElevator(elevatorNumber,RequestType.moveMotorIdle);
				}
			}
		} else {
			System.err.println(
					"Insufficient number of parameters passed to Scheduler for processing arrival sensor data");
		}
	}

	private void processFloorButtonRequest(Direction direction, int floorNumberThatPressedButton) {
		// serviceRequestQueue.add(new ServiceRequest(direction,
		// floorNumberThatPressedButton));
		//TODO: remove hard codes 
		
		int bestElevator = findBestElevator(direction,  floorNumberThatPressedButton);
		
		int elevatorAt = floorAtElevatorMap.get(bestElevator);

		elevatorServiceRequestMap.get(bestElevator).add(new ServiceRequest(direction, floorNumberThatPressedButton));

		
	
		if(elevatorStateMap.get(bestElevator) == ElevatorState.ELEVATOR_READY) {
			int temp = elevatorAt - floorNumberThatPressedButton;
			if (temp < 0)
				schedulerHost.sendCommandToElevator(bestElevator, RequestType.moveMotorUp);
			else if (temp > 0)
				schedulerHost.sendCommandToElevator(bestElevator, RequestType.moveMotorDown);
			else { // the elevator is already at the floor
				
			}
		}

	}

	private int findBestElevator(Direction direction, int floorNumber) {
		int distance = -1;
		int eleNumber = -1;
		for(Map.Entry<Integer, ElevatorState> stateEntry:this.elevatorStateMap.entrySet()) { // If there are any elevators heading in that direction add a stop to the closest
			if(stateEntry.getValue().getId() == direction.getId()) {
				int currDist = Math.abs(floorNumber - this.floorAtElevatorMap.get(stateEntry.getKey()));
				if(distance == -1 || currDist < distance) {
					distance = currDist;
					eleNumber = stateEntry.getKey();
				}
			}
		}
		
		if(eleNumber == -1) {
			for(Map.Entry<Integer, ElevatorState> stateEntry:this.elevatorStateMap.entrySet()) { // If other elevators are moving in the wrong direction get the closest idle one
				if(stateEntry.getValue().getId() == Direction.IDLE.getId()) {
					int currDist = Math.abs(floorNumber - this.floorAtElevatorMap.get(stateEntry.getKey()));
					if(distance == -1 || currDist < distance) {
						distance = currDist;
						eleNumber = stateEntry.getKey();
					}
				}
			}
		}
		
		if(eleNumber == -1) {
			eleNumber = getLeastRequested();
		}
		return eleNumber;
	}

	private int getLeastRequested() {
		int min = -1;
		int eleNumber = -1;
		for(Map.Entry<Integer, ArrayList<ServiceRequest>> requestEntry:this.elevatorServiceRequestMap.entrySet()) {
			if(requestEntry.getValue().size() < min || min == -1) {
				min = requestEntry.getValue().size();
				eleNumber = requestEntry.getKey();
			}
		}
		return eleNumber;
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
