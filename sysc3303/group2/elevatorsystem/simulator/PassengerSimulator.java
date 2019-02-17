package sysc3303.group2.elevatorsystem.simulator;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.elevator.Elevator;
import sysc3303.group2.elevatorsystem.floor.Floor;
import sysc3303.group2.elevatorsystem.scheduler.Scheduler;

/*	
 * Author: Hasan Issa
 * Contributors:
 * This is a simulation that triggers events  
 */
public class PassengerSimulator {
	private int numberOfFloors;
	private int numberOfElevators;
	private List<Floor> listOfFloors;
	private List<Elevator> listOfElevators;
	private Thread schedulerThread;
	private Scheduler scheduler;
	
	public PassengerSimulator(int numberOfFloors, int numberOfElevators) throws SocketException, UnknownHostException {
		this.numberOfFloors = numberOfFloors;
		this.numberOfElevators = numberOfElevators;
		this.listOfFloors = new ArrayList<>();
		this.listOfElevators = new ArrayList<>();

		for (int i = 0; i < numberOfFloors; i++) {
			listOfFloors.add(new Floor(i+1));
		}
		for (int i = 0; i < numberOfElevators; i++) {
			Elevator elevator = new Elevator(i+1);
			Thread t = new Thread(elevator);
			t.start();
			listOfElevators.add(elevator);
		}
		
		scheduler = new Scheduler();
		schedulerThread = new Thread(this.scheduler);
		schedulerThread.start();
	}

	private void execute() {
		print("simulate a passenger pressing floor button UP on floor 1");
		simulateFloorButtonPress(2, Direction.UP);
		// check if up button has been pressed by checking the up button floor lamp
		boolean activeLampStatus = floorButtonLampActiveStatus(2, Direction.UP);
		print("floor up lamp is " + (activeLampStatus ? "on." : "off."));
		// Wait for elevator to reach floor 2 and the door opens
		// Track that a passenger has entered the elevator
		// Passenger presses a elevator button; floor 5
		// confirm door closes
		// elevator moves in requested direction
		// elevator reaches destination floor
		// door opens and passenger leaves the elevator
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void simulateFloorButtonPress(int floor, Direction direction) {
		listOfFloors.get(floor - 1).pressFloorButton(direction);
	}

	public boolean floorButtonLampActiveStatus(int floor, Direction direction) {
		if (direction == Direction.UP) {
			if (listOfFloors.get(floor - 1).getFloorUpButtonLamp().isLampStatus()) {
				return true;
			} else {
				return false;
			}
		} else {//DOWN 
			if (listOfFloors.get(floor - 1).getFloorDownButtonLamp().isLampStatus()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public void pressFloorUp(int currentFloorNumber) {
		
	}

	public void pressFloorDown(int currentFloorNumber) {
	}

	public void chooseFloorButton(int destintationFloorNumber) {
	}

	public boolean getFloorUpLampStatus(int currentFloorNumber) {
		return false;
	}

	public boolean getFloorDownLampStatus(int currentFloorNumber) {
		return false;
	}

	public int getNumberOfFloor() {
		return numberOfFloors;
	}

	public void setNumberOfFloor(int numberOfFloor) {
		this.numberOfFloors = numberOfFloor;
	}

	public int getNumberOfElevators() {
		return numberOfElevators;
	}

	public void setNumberOfElevators(int numberOfElevators) {
		this.numberOfElevators = numberOfElevators;
	}

	public List<Floor> getListOfFloors() {
		return listOfFloors;
	}

	public void setListOfFloors(List<Floor> listOfFloors) {
		this.listOfFloors = listOfFloors;
	}

	public List<Elevator> getListOfElevators() {
		return listOfElevators;
	}

	public void setListOfElevators(List<Elevator> listOfElevators) {
		this.listOfElevators = listOfElevators;
	}
	
	public void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) throws SocketException, InterruptedException, UnknownHostException {
		//System.out.println(
		//s		"P" + numOfFloors + " floors and " + numOfElevators + " elevator...");
		int numOfFloors = 10;
		int numOfElevators = 1;
		System.out.println(
				"Initiating system simulation with " + numOfFloors + " floors and " + numOfElevators + " elevator...");
		PassengerSimulator systemSimulation = new PassengerSimulator(numOfFloors, numOfElevators);
		System.out.println("Executing simulation: start");
		systemSimulation.execute();
		systemSimulation.shutdown();
		System.out.println("Executing simulation: end");
	}

	public void shutdown() throws InterruptedException {
		this.scheduler.shutdown();
		this.schedulerThread.join();
		
	}

}
