/*	
 * Author: Hasan Issa
 * Contributors: John Turner
 * 
 * This is the led lamp inside the elevator button that indicates a button press 
 * and essentially a request to visit that floor 
 * 
 */
public class ElevatorLamp {
	private boolean lampStatus;

	public ElevatorLamp() {
		lampStatus = false;
	}
	
	public boolean isLampStatus() {
		return lampStatus;
	}
	public void setLampStatus(boolean lampStatus) {
		this.lampStatus = lampStatus;
	}
	
}
