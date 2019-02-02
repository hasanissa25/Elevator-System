/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * This is the elevator door which also controls the floor door
 */
public class ElevatorDoor {
	private boolean isDoorOpen;

	public boolean isDoorOpen() {
		return isDoorOpen;
	}
	public void setDoorOpen(boolean isDoorOpen) {
		this.isDoorOpen = isDoorOpen;
	}
	
	public void openDoor() {};
	public void closeDoor() {};

	
}
