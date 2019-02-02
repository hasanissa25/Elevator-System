/*	
 * Author: Hasan Issa
 * Contributors: John Turner
 * 
 * This is the elevator button on the inside of the car
 */
public class ElevatorButton {
	private int floorNumber;
	private ElevatorLamp buttonLamp;
	
	public ElevatorButton(int floorNumber) {
		this.floorNumber = floorNumber;
		this.buttonLamp = new ElevatorLamp();
	}
	
	public void pressButton(int floorNumber) {
		this.buttonLamp.setLampStatus(true);
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	};
	
	public ElevatorLamp getButtonLamp() {
		return this.buttonLamp;
	}
	
	public void setButtonLamp(ElevatorLamp buttonLamp) {
		this.buttonLamp = buttonLamp;
	}
	
}
