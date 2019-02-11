package sysc3303.group2.elevatorsystem.simulator.test;

import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.simulator.PassengerSimulator;

public class SystemIntegrationTest {
	private PassengerSimulator systemSimulation;

	public SystemIntegrationTest() throws SocketException, UnknownHostException {

		int numOfFloors = 10;
		int numOfElevators = 1;
		System.out.println(
				"Initiating system simulation with " + numOfFloors + " floors and " + numOfElevators + " elevator...");
		PassengerSimulator systemSimulation = new PassengerSimulator(numOfFloors, numOfElevators);
	}

	@Before
	public void setup() {

	}

	@After
	public void tearDown() {

	}

	/**
	 * Scenario 1: One person A person wants to go from floor 1 to floor 2
	 */
	@Test
	public void scenario1Test() {
		print("simulate a passenger pressing floor button UP on floor 1");
		systemSimulation.simulateFloorButtonPress(2, Direction.UP);
		// check if up button has been pressed by checking the up button floor lamp
		boolean activeLampStatus = systemSimulation.floorButtonLampActiveStatus(2, Direction.UP);
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

	/**
	 * Scenario 2: Two people First person: wants to go from floor 1 to floor 5
	 * Second person: wants to go from floor 2 to floor 4
	 */
	@Test
	public void scenario2Test() {

	}

	/**
	 * Scenario 3: three people First person: wants to go from floor 1 to floor 5
	 * Second person: wants to go from floor 2 to floor 4 Third person: wants to go
	 * from floor 6 to floor 1
	 */
	@Test
	public void scenario3Test() {

	}
	
	private void print(String s) {
		System.out.println(s);
	}


}
