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
	private int elevatorNumber;
	

	public Elevator() {}
	
	public void turnOffElevatorLamp(int floorNumber) {}
	public void handleElevatorButtonPressed(int floorNumber) {}
	public void openDoor() {}
	public void closeDoor() {}
	public void motorUp() {}
	public void motorDown() {}
	public void motorStop() {}

	public int getElevatorNumber() {
		return elevatorNumber;
	}

	public void setElevatorNumber(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}
 
  public static void main(String[] args) {}

}
