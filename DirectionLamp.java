
public class DirectionLamp {
	private Direction directionState;
	private int currentFloorNumber;
	
	public DirectionLamp(Direction directionState, int currentFloorNumber) {
		super();
		this.directionState = directionState;
		this.currentFloorNumber = currentFloorNumber;
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
