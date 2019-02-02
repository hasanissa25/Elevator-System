package sysc3303.group2.elevatorsystem.elevator;
/*	
 * Author: Hasan Issa
 * Contributors: John Turner
 * 
 * This is the elevator motor that move the motor up,  down, or idle 
 */
public class ElevatorMotor {
	
	private ElevatorMotorEnum motorState;
	
	public ElevatorMotor() {
		motorState = ElevatorMotorEnum.MOTOR_STATE_IDLE;
	}
	
	public void goUp() {
		motorState = ElevatorMotorEnum.MOTOR_STATE_UP;
	};
	
	public void goDown() {
		motorState = ElevatorMotorEnum.MOTOR_STATE_DOWN;
	};
	
	public void stop() {
		motorState = ElevatorMotorEnum.MOTOR_STATE_IDLE;
	}
	
	public ElevatorMotorEnum getMotorState() {
		return motorState;
	}
	public void setMotorState(ElevatorMotorEnum motorState) {
		this.motorState = motorState;
	}

}
