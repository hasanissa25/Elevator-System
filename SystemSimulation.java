/*	
 * Author: Hasan Issa
 * Contributors:
 * This is a simulation that triggers events  
 */
public class SystemSimulation {
	private int numberOfFloor;
	public void pressFloorUp(int currentFloorNumber) {} 
	public void pressFloorDown(int currentFloorNumber) {} 
	public void chooseFloorButton(int destintationFloorNumber) {}
	public boolean getFloorUpLampStatus(int currentFloorNumber) {
		return false;
	}
	public boolean getFloorDownLampStatus(int currentFloorNumber) {
		return false;
	}
	public int getNumberOfFloor() {
		return numberOfFloor;
	}
	public void setNumberOfFloor(int numberOfFloor) {
		this.numberOfFloor = numberOfFloor;
	}
}
