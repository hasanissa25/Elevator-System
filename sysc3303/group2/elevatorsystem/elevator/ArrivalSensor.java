package sysc3303.group2.elevatorsystem.elevator;

/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * This class detects the floor that the elevator is currently 
 * is at and sends a signal to the elevator subsystem
 */
public class ArrivalSensor implements Runnable {

	private int currentFloorAt;
	private ElevatorMotor elevatorMotor;
	private Elevator elevator;
	
	public ArrivalSensor(int currentFloorAt, ElevatorMotor elevatorMotor, Elevator elevator) {
		this.currentFloorAt = currentFloorAt;
		this.elevatorMotor = elevatorMotor;
		this.elevator = elevator;
		System.out.println("Arrival Sensor: Created a new sensor on an elevator at floor " + currentFloorAt);
	}

	@Override
	public void run() {
		while (true) {
			if (elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_DOWN) {
				goDown();
			} else if (elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_UP) {
				goUp();
			}else if (elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_IDLE) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_DOWN || elevatorMotor.getMotorState() == ElevatorMotorEnum.MOTOR_STATE_UP){
				this.elevator.sendArrivalData();
				System.out.println("Arrival Sensor: reached floor " + currentFloorAt);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public int getCurrentFloorAt() {
		return currentFloorAt;
	}

	public void goUp() {
		if(elevator.MAX_FLOORS != this.currentFloorAt) {
			this.currentFloorAt++;
			if(elevator.MAX_FLOORS == this.currentFloorAt) {
				elevatorMotor.setMotorState(ElevatorMotorEnum.MOTOR_STATE_IDLE);
			}
		}
	}

	public void goDown() {
		if(1 != this.currentFloorAt) {
			this.currentFloorAt--;
			if(1 == this.currentFloorAt) {
				elevatorMotor.setMotorState(ElevatorMotorEnum.MOTOR_STATE_IDLE);
			}
		}
	}
}
