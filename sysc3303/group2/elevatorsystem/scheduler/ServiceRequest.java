package sysc3303.group2.elevatorsystem.scheduler;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.floor.Floor;

public class ServiceRequest {
	private Direction direction;
	
	private int floor;

	public ServiceRequest(Direction direction, int floor) {
		this.direction = direction;
		this.floor = floor;
	}
	
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
}
