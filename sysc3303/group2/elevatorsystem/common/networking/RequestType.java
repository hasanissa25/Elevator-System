package sysc3303.group2.elevatorsystem.common.networking;

import java.util.Arrays;
import java.util.Collections;

public enum RequestType {
	moveMotorUp(1), moveMotorDown(2), moveMotorIdle(3), elevatorDoorOpen(4), elevatorDoorClose(5),
	/* Parameter 1: which floor the floor button was pressed from */
	floorButtonUp(5),
	/* Parameter 1: which floor the floor button was pressed from */
	floorButtonDown(6),
	/* Parameter 1: which floor the elevator is at right now */
	arrivalSensorMovingUp(7),
	/* Parameter 1: which floor the elevator is at right now */
	arrivalSensorMovingDown(8);

	private int commandNumber;

	RequestType(int commandNumber) {
		this.commandNumber = commandNumber;
	}

	public int getCommandNumber() {
		return commandNumber;
	}

	public void setCommandNumber(int commandNumber) {
		this.commandNumber = commandNumber;
	}

	public static RequestType getByCommandNumber(int commandNumber) {
		for(RequestType type : Arrays.asList(RequestType.values())) {
			if(type.getCommandNumber() == commandNumber)
				return type;
		}
		return null;
	}
}
