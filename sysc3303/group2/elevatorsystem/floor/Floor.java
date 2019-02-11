package sysc3303.group2.elevatorsystem.floor;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the floor in a building 
 * This represents the floor subsystem including the floor client that will
 * communicate over the network
 */
import java.util.HashMap;
import java.util.Map;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.DirectionLamps;

public class Floor {
	private int floorNumber;
	private FloorButton floorUpButton;
	private FloorButton floorDownButton;
	private FloorLamp floorUpButtonLamp;
	private FloorLamp floorDownButtonLamp;
	private Map<Integer, DirectionLamps> floorDirectionLampsMap;
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
	public Floor(int floorNumber) throws UnknownHostException {
		this.floorNumber = floorNumber;
		this.floorUpButton = new FloorButton(Direction.UP);
		this.floorDownButton = new FloorButton(Direction.DOWN);
		this.floorUpButtonLamp = new FloorLamp();
		this.floorDownButtonLamp = new FloorLamp();
		this.floorDirectionLampsMap = new HashMap<>();
		this.floorClient = new FloorClient(5000, InetAddress.getLocalHost().getHostName());
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

	public Map<Integer, DirectionLamps> getFloorDirectionLampsMap() {
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
