package sysc3303.group2.elevatorsystem.common;
/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the lamp that indicates the status of the elevator inside the elevator
 * and outside the elevator on the floor 
 */
public class DirectionLamps {
	private Direction directionState;
	private int currentFloorNumber;
	
	public DirectionLamps() {
	}

	public Direction getDirectionState() {
		return directionState;
	}
	public void setDirectionState(Direction directionState) {
		this.directionState = directionState;
	}
	public int getCurrentFloorNumber() {
		return currentFloorNumber;
	}
	public void setCurrentFloorNumber(int currentFloorNumber) {
		this.currentFloorNumber = currentFloorNumber;
	}

	//public DirectionLamp() {
		//example: directionState= Direction.UP;
		//directionState= Direction.Down
	//}
}
