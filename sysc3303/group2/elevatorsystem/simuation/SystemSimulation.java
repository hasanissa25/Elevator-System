package sysc3303.group2.elevatorsystem.simuation;

import java.util.ArrayList;
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
	private Scheduler scheduler;

	public SystemSimulation(int numberOfFloors, int numberOfElevators) {
		this.numberOfFloors = numberOfFloors;
		this.numberOfElevators = numberOfElevators;
		this.listOfFloors = new ArrayList<>();
		this.listOfElevators = new ArrayList<>();
		this.scheduler = new Scheduler();

		for (int i = 0; i < numberOfFloors; i++) {
			listOfFloors.add(new Floor(i+1));
		}
		for (int i = 0; i < numberOfElevators; i++) {
			listOfElevators.add(new Elevator(i+1));
		}

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
			if (listOfFloors.get(floor - 1).getFloorUpLampStatus()) {
				print("floor up lamp is turned on");
			} else {
				print("floor up lamp is turned off");
			}
		} else {//DOWN 
			if (listOfFloors.get(floor - 1).getFloorDownLampStatus()) {
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

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		int numOfFloors = 10;
		int numOfElevators = 1;
		System.out.println(
				"Initiating system simulation with " + numOfFloors + " floors and " + numOfElevators + " elevator...");
		SystemSimulation systemSimulation = new SystemSimulation(numOfFloors, numOfElevators);
		System.out.println("Executing simulation: start");
		systemSimulation.execute();
		System.out.println("Executing simulation: end");
	}

}
