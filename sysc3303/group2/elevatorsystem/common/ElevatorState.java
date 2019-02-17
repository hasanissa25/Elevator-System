package sysc3303.group2.elevatorsystem.common;

import java.util.Arrays;

import sysc3303.group2.elevatorsystem.common.networking.RequestType;

/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the state machine of the elevator 
 */
public enum ElevatorState {
	ELEVATOR_MOVING_UP(1), ELEVATOR_MOVING_DOWN(2), ELEVATOR_READY(3), ELEVATOR_DOOR_OPEN(4), ELEVATOR_DOOR_CLOSED_AND_STOPPED(5);

	private int id;

	ElevatorState(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static ElevatorState getByid(int id) {
		for (ElevatorState type : Arrays.asList(ElevatorState.values())) {
			if (type.getId() == id)
				return type;
		}
		return null;
	}
}
