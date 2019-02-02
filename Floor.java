/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the floor in a building 
 * This represents the floor subsystem including the floor client that will
 * communicate over the network
 */
import java.util.*;
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
	
	
	//to pass to floorclient with a certain hostport and a certain hostip
	public Floor(int hostPort, String hostIp) {
		floorUpButton=new FloorButton(Direction.UP);
		floorDownButton=new FloorButton(Direction.DOWN);
		floorUpButtonLamp=new FloorLamp();
		floorDownButtonLamp=new FloorLamp();
		floorDirectionLampsMap = new HashMap<>();
		floorClient= new FloorClient(hostPort, hostIp);
	} 
	//to pass to floorclient with a default hostport and a default hostip
	public Floor() {
		floorUpButton=new FloorButton(Direction.UP);
		floorDownButton=new FloorButton(Direction.DOWN);
		floorUpButtonLamp=new FloorLamp();
		floorDownButtonLamp=new FloorLamp();
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

	private void handleButtonPressed(Direction direction) {
		
	}
	public void pressFloorButton(Direction direction) {}
	public boolean getFloorUpLampStatus() {
		return false;
	}
	public boolean getFloorDownLampStatus() {
		return false;
	}

	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
}
