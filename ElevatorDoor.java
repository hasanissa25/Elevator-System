/*	
 * Author: Hasan Issa
 * Contributors: John Turner
 * 
 * This is the elevator door which also controls the floor door
 */
public class ElevatorDoor {
	private boolean isDoorOpen;

	public ElevatorDoor() {
		isDoorOpen = false;
	}
	
	public boolean isDoorOpen() {
		return isDoorOpen;
	}
	
	public void setDoorOpen(boolean isDoorOpen) {
		this.isDoorOpen = isDoorOpen;
	}
	
	public void openDoor() {
		this.isDoorOpen = true;
	};
	public void closeDoor() {
		this.isDoorOpen = false;
	};

	
}
