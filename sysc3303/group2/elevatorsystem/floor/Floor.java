package sysc3303.group2.elevatorsystem.floor;

/*	
 * Author: Hasan Issa
 * Contributors:
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
	private FloorLamp floorUpButtonLamp;
	private FloorLamp floorDownButtonLamp;
	private Map<Integer, DirectionLamp> floorDirectionLampsMap;
	private FloorClient floorClient;

	// to pass to floorclient with a certain hostport and a certain hostip
	public Floor(int floorNumber, int hostPort, String hostIp) {
		this.floorNumber = floorNumber;
		this.floorUpButton = new FloorButton(Direction.UP);
		this.floorDownButton = new FloorButton(Direction.DOWN);
		this.floorUpButtonLamp = new FloorLamp();
		this.floorDownButtonLamp = new FloorLamp();
		this.floorDirectionLampsMap = new HashMap<>();
		this.floorClient = new FloorClient(hostPort, hostIp);
	}

	// to pass to floorclient with a default hostport and a default hostip
	public Floor(int floorNumber) {
		this.floorNumber = floorNumber;
		this.floorUpButton = new FloorButton(Direction.UP);
		this.floorDownButton = new FloorButton(Direction.DOWN);
		this.floorUpButtonLamp = new FloorLamp();
		this.floorDownButtonLamp = new FloorLamp();
		this.floorDirectionLampsMap = new HashMap<>();
		this.floorClient = new FloorClient(5000, "127.0.0.1");
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

	public FloorLamp getFloorUpButtonLamp() {
		return floorUpButtonLamp;
	}

	public void setFloorUpButtonLamp(FloorLamp floorUpButtonLamp) {
		this.floorUpButtonLamp = floorUpButtonLamp;
	}

	public FloorLamp getFloorDownButtonLamp() {
		return floorDownButtonLamp;
	}

	public void setFloorDownButtonLamp(FloorLamp floorDownButtonLamp) {
		this.floorDownButtonLamp = floorDownButtonLamp;
	}

	public Map<Integer, DirectionLamp> getFloorDirectionLampsMap() {
		return floorDirectionLampsMap;
	}

	public void pressFloorButton(Direction direction) {
		floorClient.sendFloorButtonRequest(direction, this.floorNumber);
		if(direction == Direction.UP)
			floorUpButtonLamp.setLampStatus(true);
		else
			floorDownButtonLamp.setLampStatus(true);
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

}
