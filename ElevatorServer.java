/*	
 * Author: Hasan Issa
 * Contributors:
 * 
 * The elevator software/controller that is responsible for 
 * communicating over the network and processing elevator commands 
 */
import java.net.DatagramSocket;

public class ElevatorServer {

	private int portNumber;
	private DatagramSocket serverSocket;
	
	private void sendCurrentFloorNumberAndElevatorDirection(int currentFloorNumber, Direction direction) {
		
	}
	private void sendElevatorButtonRequest(int floorNumber) {
		
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	public DatagramSocket getServerSocket() {
		return serverSocket;
	}
	public void setServerSocket(DatagramSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
}
