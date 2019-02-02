package sysc3303.group2.elevatorsystem.common.networking;

public enum RequestType {
moveMotorUp,
moveMotorDown,
moveMotorIdle,
elevatorDoorOpen,
elevatorDoorClose,
/* Parameter 1: which floor the floor button was pressed from */
floorButtonUp,
/* Parameter 1: which floor the floor button was pressed from */
floorButtonDown,
/* Parameter 1: which floor the elevator is at right now */
arrivalSensorMovingUp,
/* Parameter 1: which floor the elevator is at right now */
arrivalSensorMovingDown
}
