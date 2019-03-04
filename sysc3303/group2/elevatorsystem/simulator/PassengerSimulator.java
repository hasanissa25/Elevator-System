package sysc3303.group2.elevatorsystem.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javafx.util.converter.LocalTimeStringConverter;
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
			listOfFloors.add(new Floor(i + 1));
		}
		for (int i = 0; i < numberOfElevators; i++) {
			Elevator elevator = new Elevator(i + 1, 6000 + i);
			Thread t = new Thread(elevator);
			t.start();
			listOfElevators.add(elevator);
		}

		scheduler = new Scheduler();
		schedulerThread = new Thread(this.scheduler);
		schedulerThread.start();
	}

	private void execute() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		String line = reader.readLine();
		print("Reading Simulation File; Input.txt");

		List<SimulationEvent> simulationEvents = new ArrayList<>();

		while (line != null) {
			StringTokenizer st = new StringTokenizer(line, " ");
			String time = st.nextToken();
			String requestingFloor = st.nextToken();
			String direction = st.nextToken();
			String destinationFloor = st.nextToken();
			LocalTime localTime = LocalTime.parse(time);
			Direction direction2 = direction.equals("UP") ? Direction.UP : Direction.DOWN;
			int destinationFloor2 = Integer.parseInt(destinationFloor);
			int requestingFloor2 = Integer.parseInt(requestingFloor);

			SimulationEvent se = new SimulationEvent(localTime, requestingFloor2, direction2, destinationFloor2);
			simulationEvents.add(se);
			// read next line
			line = reader.readLine();
		}
		reader.close();

		for (SimulationEvent e : simulationEvents) {
			print("Simulate a passenger pressing floor button " + e.getDirection() + " on floor "
					+ e.getRequestingFloor());
			simulateFloorButtonPress(e.getRequestingFloor(), e.getDirection());
			boolean activeLampStatus = floorButtonLampActiveStatus(e.getRequestingFloor(), e.getDirection());

			print("Floor " +e.getDirection()+ " lamp is " + (activeLampStatus ? "On." : "Off."));
		}
		
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
		} else {// DOWN
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

	public static void main(String[] args) throws InterruptedException, IOException {
		// System.out.println(
		// s "P" + numOfFloors + " floors and " + numOfElevators + " elevator...");
		int numOfFloors = 10;
		int numOfElevators = 2;
		System.out.println(
				"Initiating system simulation with " + numOfFloors + " floors and " + numOfElevators + " elevator...");
		PassengerSimulator systemSimulation = new PassengerSimulator(numOfFloors, numOfElevators);
		System.out.println("Executing simulation: Start");
		systemSimulation.execute();
		systemSimulation.shutdown();
		System.out.println("Executing simulation: End");
	}

	public void shutdown() throws InterruptedException {
		this.scheduler.shutdown();
		this.schedulerThread.join();
//		for(Elevator e : listOfElevators) {
//			e.shutdown();
//		}
	}

}
