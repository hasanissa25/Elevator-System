package sysc3303.group2.elevatorsystem.elevator;
/*	
 * Author: Hasan Issa
 * Contributors:John Turner
 * 
 * The elevator software/controller that is responsible for 
 * communicating over the network and processing elevator commands 
 */
import java.net.DatagramSocket;
import java.net.SocketException;

import sysc3303.group2.elevatorsystem.common.Direction;

public class ElevatorServer {

	private int portNumber;
	private DatagramSocket serverSocket;
	
	public ElevatorServer(int portNumber) {
		this.portNumber = portNumber;
		
		try {
			serverSocket = new DatagramSocket(portNumber);  // Create a Datagram socket bound to this port
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
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
