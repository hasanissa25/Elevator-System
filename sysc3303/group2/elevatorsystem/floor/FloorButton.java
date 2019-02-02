package sysc3303.group2.elevatorsystem.floor;
import sysc3303.group2.elevatorsystem.common.Direction;

/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the button on the floor to request the elevator 
 */
public class FloorButton {
	private Direction direction;

	public FloorButton(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	
	public void pressButton() {}
}
