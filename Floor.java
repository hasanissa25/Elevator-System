import java.util.*;

public class Floor {

  private int PORT;
  private String FILE_NAME;
  private DatagramSocket socket;
  private DatagramPacket packet;
  private Calendar cal;
  private SimpleDateFormat time;
  private InetAddress IPAddress;
  private InetAddress holdAddress;
  private int holdPort;

  static final int IDLE_STATE = 1;
  static final int WAITING_FOR_ELE_UP = 2;
  static final int WAITING_FOR_ELE_DOWN = 3;
  static final int WAITING_FOR_ELE_BOTH = 4;
  
  static final int DOWN_REQUEST = 1;
  static final int UP_REQUEST = 2;
  
  public Floor() {}

  public void sendAndReceive(String) {}

  public void run() {
	  
	  boolean Running = true;
		
		while (Running) {
			
			int currState = getState();
			
			switch (currState){
			
			case IDLE_STATE: // Idle waiting for a button to be pressed
				int currRequest = getRequest();
				
				if(currRequest == DOWN_REQUEST) {
					makeDownRequest(); // Send the request to the scheduler
					setState(WAITING_FOR_ELE); // Change state to waiting for the elevator
				}
				
				else if (currRequest == UP_REQUEST) {
					makeUpRequest(); // Send the request to the scheduler
					setState(WAITING_FOR_ELE); // change the state to waiting for the elevator
				}
				break;
				
			case WAITING_FOR_ELE_UP: // Waiting for an UPWARDS elevator
				if(UpArrived()) { // Check for the arrival of and UPWARDS elevator
					setState(IDLE_STATE); // Change the state to UPWARDS Elevator arrived
				}
				break;
			case WAITING_FOR_ELE_DOWN: // Waiting for a DOWNWARDS elevator
				if(DownArrived()) { // check for the arrival of a DOWNWARDS elevator
					setState(IDLE_STATE); // Change the state to DOWNWARDS elevator arrived
				}
			case WAITING_FOR_ELE_BOTH: // If there are both an UP and DOWN request at the same time
				if(upArrived()) { // Check if one arrives if so change the state to waiting for the other
					setState(WAITING_FOR_ELE_DOWN);
				}
				else if(downArrived()) {
					setState(WAITING_FOR_ELE_DOWN);
				}
				break;
				
			}
	  
  }

  public static void main(String[] args) {}

}
