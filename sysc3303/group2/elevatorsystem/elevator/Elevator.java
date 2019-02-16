package sysc3303.group2.elevatorsystem.elevator;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.DirectionLamps;
import sysc3303.group2.elevatorsystem.common.ElevatorState;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;

public class Elevator implements Runnable {

	static final int MAX_FLOORS = 10; // 0 -> 9 : Number of floors in the building, used for button/lamp arrays
	private int elevatorNumber;

	private ElevatorMotor elevatorMotor;
	private ArrivalSensor arrivalSensor;
	private ElevatorServer elevatorServer;

	private ElevatorButton elevatorButtons[];
	private ElevatorDoor elevatorDoor;
	private DirectionLamps elevatorDirectionLamps;

	public Elevator(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
		this.elevatorMotor = new ElevatorMotor();
		this.arrivalSensor = new ArrivalSensor(1, elevatorMotor, this); // Start the elevator on the ground floor
		this.elevatorServer = new ElevatorServer(); // The elevatorNumber is used as the Port to communicate with it
		this.elevatorDoor = new ElevatorDoor();

		this.elevatorButtons = new ElevatorButton[MAX_FLOORS]; // Create buttons for each floor of the building
		for (int i = 0; i < MAX_FLOORS; i++) { // Floor 0 is the ground floor of the building, 1 is the 1st floor above
												// ground floor
			elevatorButtons[i] = new ElevatorButton(i);
		}

		this.elevatorDirectionLamps = new DirectionLamps();
		Thread t = new Thread(this.arrivalSensor);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			Message m = elevatorServer.waitForANetworkRequest();
			if (m == null)
				continue;
			System.out.println("Elevator: (id=" + elevatorNumber + ") processing request: " + m);
			switch (m.getRequestType()) {
			case elevatorDoorClose:
				System.out.println("Door closed");
				elevatorDoor.setDoorOpen(false);
				break;
			case elevatorDoorOpen:
				System.out.println("Door opened");
				elevatorDoor.setDoorOpen(true);
				break;
			case moveMotorDown:
				System.out.println("Elevator going down");
				elevatorDirectionLamps.setDirectionState(Direction.DOWN);
				elevatorMotor.setMotorState(ElevatorMotorEnum.MOTOR_STATE_DOWN);
				break;
			case moveMotorIdle:
				System.out.println("Elevator stopped");
				elevatorDirectionLamps.setDirectionState(null);
				elevatorMotor.setMotorState(ElevatorMotorEnum.MOTOR_STATE_IDLE);
				break;
			case moveMotorUp:
				System.out.println("Elevator going up");
				elevatorDirectionLamps.setDirectionState(Direction.UP);
				elevatorMotor.setMotorState(ElevatorMotorEnum.MOTOR_STATE_UP);
				break;
			default:
				break;
			}
		}
	}

	public void turnOffElevatorLamp(int floorNumber) {
		elevatorButtons[floorNumber].getButtonLamp().setLampStatus(false); // Turn off that floor's button/lamp
	}

	private void pressElevatorButton(int floorNumber) {
		elevatorButtons[floorNumber].getButtonLamp().setLampStatus(true); // Turn on that floor's button/lamp

		// Send the request to the Scheduler
		elevatorServer.sendCommandToHost(RequestType.elevatorButtonRequest, floorNumber, this.elevatorNumber);
	}

	public int getElevatorNumber() {
		return elevatorNumber; // Get the number of this elevator
	}

	public void setElevatorNumber(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber; // Set the number of this elevator
	}

	public static void main(String[] args) {
		Elevator e = new Elevator(Integer.parseInt(args[0]));
		e.run();
	}

	public void sendArrivalData() {
		ElevatorState computedElevatorState = null;
		if(elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_IDLE)
			if(elevatorDoor.isDoorOpen())
				computedElevatorState = ElevatorState.ELEVATOR_DOOR_OPEN;
			else computedElevatorState = ElevatorState.ELEVATOR_DOOR_CLOSED_AND_STOPPED;
		else if(elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_UP)
			computedElevatorState = ElevatorState.ELEVATOR_MOVING_UP;
		else if(elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_DOWN)
			computedElevatorState = ElevatorState.ELEVATOR_MOVING_DOWN;
		
		this.elevatorServer.sendCommandToHost(RequestType.arrivalSensorData, this.elevatorNumber, this.arrivalSensor.getCurrentFloorAt(), computedElevatorState.getId());
		
	}

}
