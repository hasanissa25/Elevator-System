package sysc3303.group2.elevatorsystem.floor;
/*	
 * Author: Hasan Issa
 * Contributors:John Turner
 * This is the floor in a building 
 * This represents the floor subsystem including the floor client that will
 * communicate over the network
 */
import java.util.*;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.DirectionLamp;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Floor {
	private int floorNumber;
	private FloorButton floorUpButton;
	private FloorButton floorDownButton;
	private Map<Integer, DirectionLamp> floorDirectionLampsMap;
	private FloorClient floorClient;
	
	
	//to pass to floorclient with a certain hostport and a certain hostip
	public Floor(int floorNumber, int hostPort, String hostIp) {
		this.floorNumber = floorNumber;
		floorUpButton=new FloorButton(Direction.UP);
		floorDownButton=new FloorButton(Direction.DOWN);
		floorDirectionLampsMap = new HashMap<>();
		floorClient= new FloorClient(hostPort, hostIp);
	} 
	
	//to pass to floorclient with a default hostport and a default hostip
	public Floor(int floorNumber) {
		this.floorNumber = floorNumber;
		floorUpButton=new FloorButton(Direction.UP);
		floorDownButton=new FloorButton(Direction.DOWN);
		floorDirectionLampsMap = new HashMap<>();
		floorClient= new FloorClient(5000, "127.0.0.1");
	} 

	public FloorButton getFloorUpButton() {
		return floorUpButton;
	}


	public void setFloorUpButton(FloorButton floorUpButton) {
		this.floorUpButton = floorUpButton;
	}


	public FloorButton getFloorDownButton() {
		return floorDownButton;
	}


	public void setFloorDownButton(FloorButton floorDownButton) {
		this.floorDownButton = floorDownButton;
	}

	public Map<Integer, DirectionLamp> getFloorDirectionLampsMap() {
		return floorDirectionLampsMap;
	}

	private void handleButtonPressed(Direction direction) {
		floorClient.sendFloorButtonRequest(direction,  this.floorNumber);
	}
	
	public void pressFloorButton(Direction direction) {
		if(direction == Direction.DOWN) {
			handleButtonPressed(Direction.DOWN);
			this.floorDownButton.pressButton();
		} 
		else if(direction == Direction.UP) {
			handleButtonPressed(Direction.UP);
			this.floorUpButton.pressButton();
		}
	}
	
	public boolean getFloorUpLampStatus() {
		return this.floorUpButton.getButtonLamp().isLampStatus();
	}
	
	public boolean getFloorDownLampStatus() {
		return this.floorDownButton.getButtonLamp().isLampStatus();
	}

	public int getFloorNumber() {
		return floorNumber;
	}
	
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
}
