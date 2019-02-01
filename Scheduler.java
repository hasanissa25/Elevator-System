import java.util.*;

public class Scheduler {

  private int PORT_FLOOR;
  private int PORT_ELEVATOR;
  private DatagramSocket socket_floor;
  private DatagramSocket socket_elevator;
  private InetAddress IPAddress;
  private Calendar cal;
  private SimpleDateFormat time;
  private DatagramPacket packet_floor;
  private DatagramPacket packet_elevator;
  private InetAddress holdAddressFloor;
  private int holdPortFloor;
  private InetAddress holdAddressElevator;
  private int holdPortElevator;

  public Scheduler() {}

  public void run() {
	  
	  int currState = getCurrentState();
	  
	  switch (currState) {
	  
	  	case IDLE_STATE:
	  		int currRequest = getRequest();
	  		
	  		if (currRequest == DOWN_REQUEST) {
	  			setState(DOWN_REQUEST_STATE);
	  		}
	  		else if(currRequest == UP_REQUEST) {
	  			setState(UP_REQUEST_STATE);
	  		}
	  		break;
	  		
	  	case DOWN_REQUEST_STATE:
	  		int elevatorNum = findElevator(floorNumber, DOWN);
	  		if(elevatorNum != -1) {
	  			sendElevator(elevatorNum, floorNum, DOWN)
	  			setState(DOWN_REQUEST_SENT)
	  		}
	  		break;
	  		
	  	case UP_REQUEST_STATE:
	  		int elevatorNum = findElevator(floorNumber, UP);
	  		if(elevatorNum != -1) {
	  			sendElevator(elevatorNum, floorNum, UP)
	  			setState(UP_REQUEST_SENT)
	  		}
	  		break;
	  		
	  	case UP_REQUEST_SENT:
	  		
	  		break;
	  		
	  	case DOWN_REQUEST_SENT:
	  		
	  		break;
	  
	  
	  }
	  
	  
  }

  public static void main(String[] args) {}

}
