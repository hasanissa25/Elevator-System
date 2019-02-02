package sysc3303.group2.elevatorsystem.elevator;
/*	
 * Author: Hasan Issa
 * Contributors:John Turner
 * 
 * This is a subsystem that contains all the various elevator components and functions 
 */
import java.util.*;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.DirectionLamp;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Elevator {
	
	static final int MAX_FLOORS = 10; // 0 -> 9 : Number of floors in the building, used for button/lamp arrays
	private int elevatorNumber;
	
	private ElevatorState elevatorState;
	private ElevatorMotor elevatorMotor;
	private ArrivalSensor arrivalSensor;
	private ElevatorServer elevatorServer;
	
	private ElevatorButton elevatorButtons[];
	private ElevatorDoor elevatorDoor;
	private DirectionLamp elevatorDirectionLamp[];
	
	
	
	public Elevator() {
		this.elevatorState = ElevatorState.ELEVATOR_STOP; // The elevator starts out in an IDLE state
		this.elevatorMotor=new ElevatorMotor();
		this.arrivalSensor=new ArrivalSensor(0); // Start the elevator on the ground floor
		this.elevatorServer= new ElevatorServer(elevatorNumber); // The elevatorNumber is used as the Port to communicate with it
		this.elevatorDoor=new ElevatorDoor();
		
		this.elevatorButtons=new ElevatorButton[MAX_FLOORS]; // Create buttons for each floor of the building
		for(int i = 0; i < MAX_FLOORS; i++) { // Floor 0  is the ground floor of the building, 1 is the 1st floor above ground floor
			elevatorButtons[i] = new ElevatorButton(i);
		}
		
		this.elevatorDirectionLamp=new DirectionLamp[Direction.values().length]; // Create lamps for each direction
		elevatorDirectionLamp[0] = new DirectionLamp(Direction.UP, arrivalSensor.getCurrentFloorAt()); // UP and DOWN lamps are created... 
		elevatorDirectionLamp[1] = new DirectionLamp(Direction.DOWN, arrivalSensor.getCurrentFloorAt()); // at the current floor
	}
	
	public void turnOffElevatorLamp(int floorNumber) {
		elevatorButtons[floorNumber].getButtonLamp().setLampStatus(false); // Turn off that floor's button/lamp
	}
	
	private void handleElevatorButtonPressed(int floorNumber) {
		elevatorButtons[floorNumber].getButtonLamp().setLampStatus(true); // Turn on that floor's button/lamp
		
		// Send the request to the Scheduler
	}
	
	public void openDoor() {
		this.elevatorDoor.openDoor(); // open the elevator's door
	}
	
	public void closeDoor() {
		this.elevatorDoor.closeDoor(); // close the elevator's door
	}
	
	public void motorUp() {
		this.elevatorMotor.goUp(); // Turn the motor's state to UP
	}
	public void motorDown() {
		this.elevatorMotor.goDown(); // Turn the motor's state to DOWN

	}
	public void motorStop() {
		this.elevatorMotor.stop(); // Turn the motor's state to IDLE
	}

	public int getElevatorNumber() {
		return elevatorNumber; // Get the number of this elevator
	}

	public void setElevatorNumber(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber; // Set the number of this elevator
	}
 
  public static void main(String[] args) {}

}
