package sysc3303.group2.elevatorsystem.floor;
/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the led on the button on the outside of the elevator on a floor
 * that indicates whether a button has been pressed
 */
public class FloorLamp {
	private boolean lampStatus;

	public boolean isLampStatus() {
		return lampStatus;
	}

	public void setLampStatus(boolean lampStatus) {
		this.lampStatus = lampStatus;
	}
	
}
