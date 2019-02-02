package sysc3303.group2.elevatorsystem.elevator;
/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * This class detects the floor that the elevator is currently 
 * is at and sends a signal to the elevator subsystem
 */
public class ArrivalSensor {

	private int currentFloorAt;

	public ArrivalSensor(int currentFloorAt) {
		super();
		this.currentFloorAt = currentFloorAt;
	}

	public int getCurrentFloorAt() {
		return currentFloorAt;
	}

	public void setCurrentFloorAt(int currentFloorAt) {
		this.currentFloorAt = currentFloorAt;
	}
	
}
