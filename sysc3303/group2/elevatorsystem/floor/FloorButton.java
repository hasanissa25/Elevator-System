package sysc3303.group2.elevatorsystem.floor;
import sysc3303.group2.elevatorsystem.common.Direction;

/*	
 * Author: Hasan Issa
 * Contributors: John Turner
 * This is the button on the floor to request the elevator 
 */
public class FloorButton {
	private Direction direction;
	private FloorLamp buttonLamp;

	public FloorButton(Direction direction) {
		this.direction = direction;
		buttonLamp = new FloorLamp();
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public FloorLamp getButtonLamp() {
		return this.buttonLamp;
	}
	
	public void setButtonLamp(FloorLamp buttonLamp) {
		this.buttonLamp = buttonLamp;
	}
	
	public void pressButton() {
		this.buttonLamp.setLampStatus(true);
	}
	
	public void clearButton() {
		this.buttonLamp.setLampStatus(false);
	}
}
