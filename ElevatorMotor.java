/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * This is the elevator motor that move the motor up or down 
 */
public class ElevatorMotor {
	
	private ElevatorMotorEnum motorState;
	public void goUp() {};
	public void goDown() {};
	public void stop() {}
	public ElevatorMotorEnum getMotorState() {
		return motorState;
	}
	public void setMotorState(ElevatorMotorEnum motorState) {
		this.motorState = motorState;
	}

}
