/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * This is the led lamp inside the elevator button that indicates a button press 
 * and essentially a request to visit that floor 
 * 
 */
public class ElevatorLamp {
	private boolean lampStatus;
	private int floorDisplayNumber;

	public boolean isLampStatus() {
		return lampStatus;
	}
	public void setLampStatus(boolean lampStatus) {
		this.lampStatus = lampStatus;
	}
	public int getFloorDisplayNumber() {
		return floorDisplayNumber;
	}
	public void setFloorDisplayNumber(int floorDisplayNumber) {
		this.floorDisplayNumber = floorDisplayNumber;
	}
	
}
