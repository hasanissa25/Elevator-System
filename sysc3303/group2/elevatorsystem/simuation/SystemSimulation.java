package sysc3303.group2.elevatorsystem.simuation;

import java.net.SocketException;
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
public class SystemSimulation {
	private int numberOfFloors;
	private int numberOfElevators;
	private List<Floor> listOfFloors;
	private List<Elevator> listOfElevators;
	private Thread schedulerThread;
	
	public SystemSimulation(int numberOfFloors, int numberOfElevators) throws SocketException {
		this.numberOfFloors = numberOfFloors;
		this.numberOfElevators = numberOfElevators;
		this.listOfFloors = new ArrayList<>();
		this.listOfElevators = new ArrayList<>();

		for (int i = 0; i < numberOfFloors; i++) {
			listOfFloors.add(new Floor(i+1));
		}
		for (int i = 0; i < numberOfElevators; i++) {
			listOfElevators.add(new Elevator(i));
		}
		schedulerThread = new Thread(new Scheduler());
		schedulerThread.start();
	}

	private void execute() {
		print("simulate pressing floor button UP on floor 1");
		simulateFloorButtonPress(1, Direction.UP);
		print("simulate pressing floor button Down on floor 2");
		simulateFloorButtonPress(2, Direction.DOWN);
		print("simulate pressing floor button UP on floor 3");
		simulateFloorButtonPress(3, Direction.UP);
	}

	public void simulateFloorButtonPress(int floor, Direction direction) {
		listOfFloors.get(floor - 1).pressFloorButton(direction);
		// check if up button has been pressed by checking the up button floor lamp
		if (direction == Direction.UP) {
			if (listOfFloors.get(floor - 1).getFloorUpButtonLamp().isLampStatus()) {
				print("floor up lamp is turned on");
			} else {
				print("floor up lamp is turned off");
			}
		} else {//DOWN 
			if (listOfFloors.get(floor - 1).getFloorDownButtonLamp().isLampStatus()) {
				print("floor down lamp is turned on");
			} else {
				print("floor down lamp is turned off");
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

	public static void main(String[] args) throws SocketException, InterruptedException {
		int numOfFloors = 10;
		int numOfElevators = 1;
		System.out.println(
				"Initiating system simulation with " + numOfFloors + " floors and " + numOfElevators + " elevator...");
		SystemSimulation systemSimulation = new SystemSimulation(numOfFloors, numOfElevators);
		System.out.println("Executing simulation: start");
		systemSimulation.execute();
		systemSimulation.shutdown();
		System.out.println("Executing simulation: end");
	}

	private void shutdown() throws InterruptedException {
		
	}

}
