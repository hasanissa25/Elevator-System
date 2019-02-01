/*	
 * Author: Hasan Issa
 * Contributors:
 * 
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
