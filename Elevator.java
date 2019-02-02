/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * This is a subsystem that contains all the various elevator components and functions 
 */
import java.util.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Elevator {
	private ElevatorMotor elevatorMotor;
	private ElevatorState elevatorState;
	private ArrivalSensor arrivalSensor;
	private ElevatorServer elevatorServer;
	

	public Elevator() {
		this.elevatorMotor=new ElevatorMotor();
		this.elevatorState=ElevatorState.ELEVATOR_STOP;
		this.arrivalSensor=new ArrivalSensor(0);
		this.elevatorServer= new ElevatorServer();
		
	}
	
	public void turnOffElevatorLamp(int floorNumber) {}
	private void handleElevatorButtonPressed(int floorNumber) {}
	public void openDoor() {}
	public void closeDoor() {}
	public void motorUp() {
		this.elevatorMotor.goUp();
	}
	public void motorDown() {
		this.elevatorMotor.goDown();

	}
	public void motorStop() {
		this.elevatorMotor.stop();

	}

	public int getElevatorNumber() {
		return elevatorNumber;
	}

	public void setElevatorNumber(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}
 
  public static void main(String[] args) {}

}
