package sysc3303.group2.elevatorsystem.simulator;

import java.time.LocalTime;

import sysc3303.group2.elevatorsystem.common.Direction;

public class SimulationEvent {
	private int requestingFloor;
	private Direction direction;
	private int destinationFloor;
	private LocalTime time;
	

	public SimulationEvent(LocalTime time, int requestingFloor, Direction direction, int destinationFloor) {
		super();
		this.time = time;
		this.requestingFloor = requestingFloor;
		this.direction = direction;
		this.destinationFloor = destinationFloor;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public int getRequestingFloor() {
		return requestingFloor;
	}

	public void setRequestingFloor(int requestingFloor) {
		this.requestingFloor = requestingFloor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

}
