package sysc3303.group2.elevatorsystem.common;

import java.util.Arrays;

/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * This is an enumerated class that resembles the direction the elevator 
 * could move in
 */
public enum Direction {
UP(1),DOWN(2),IDLE(3);
	
	private int id;

	Direction(int id) {
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
