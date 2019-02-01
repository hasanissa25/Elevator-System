import java.util.*;

public class Elevator {

	private int PORT;
	private DatagramSocket socket;
	private Calendar cal;
	private SimpleDateFormat time;
	private elevatorState int;
	private floorSensor int;
	
	static final int TOP_FLOOR = 10; // The highest floor the elevator can reach
	
	static final int IDLE_STATE = 1; // States that the elevator can be in
	static final int PREP_DOWN = 2;
	static final int PREP_UP = 3;
	static final int MOVE_ELE = 4;
	
	public Elevator(int startingFloor) {
		
		setState(IDLE_STATE);
		setFloor(startingFloor);
		
		
	}

	public void run() {
		boolean Running = true;
		
		while (Running) {
			
			int currState = getState();
			
			switch (currState){
			
			case IDLE_STATE: // Idle or Checking for a new request
				int destinationFloor = getRequest(); // Check for a request from the scheduler
				if(destinationFloor == floorSensor) { // Compare the destination to the current floor to find direction
					setState(IDLE_STATE);
				}
				else if(destinationFloor > getCurrFloor()) {
					setState(PREP_UP);
				}
				else {
					setState(PREP_DOWN);
				}
				break;
				
			case PREP_DOWN: // Prepare to Move Down
				openDoors();
				closeDoors(); // Routine for loading passengers
				setMotorDown(); // Start the elevator moving
				setState(MOVE_ELE); // No matter the direction once the elevator is moving the state can be set to MOVE_ELE
				break;
				
			case PREP_UP: // Prepare to Move Up
				openDoors();
				closeDoors(); // Routine for loading passengers
				setMotorUp();
				setState(MOVE_ELE);
				break;
				
			case MOVE_ELE: // Once the motor is started all that has to be done is checking if the destination has been reached
				if(checkFloor()) {
					setMotorStop(); // If the elevator has arrived stop it
					openDoors(); // Unload the passengers
					setState(IDLE_STATE); // Set it to idle, if there is another request it will receive it from the idle state.
				}
				break;
				
			}
		}
		
	}

	public static void main(String[] args) {
		run();
	}
}
