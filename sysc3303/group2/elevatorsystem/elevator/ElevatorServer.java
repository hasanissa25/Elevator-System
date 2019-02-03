package sysc3303.group2.elevatorsystem.elevator;

/*	
 * Author: Hasan Issa
 * Contributors:John Turner
 * 
 * The elevator software/controller that is responsible for 
 * communicating over the network and processing elevator commands 
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.Utility;
import sysc3303.group2.elevatorsystem.common.networking.Message;

public class ElevatorServer {

	private static final int BUFFER_SIZE = 1000;
	private int portNumber;
	private DatagramSocket serverSocket;
	private DatagramPacket elevatorInfo;
	private int hostPort;
	
	public ElevatorServer() {
		this.portNumber = 5001;
		
		try {
			serverSocket = new DatagramSocket(portNumber);  // Create a Datagram socket bound to this port
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public Message waitForANetworkRequest() {

		byte data[] = new byte[BUFFER_SIZE];
		DatagramPacket receivePacket = new DatagramPacket(data, data.length);

		// Block until a datagram packet is received from receiveSocket.
		try {
			serverSocket.receive(receivePacket);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int len = receivePacket.getLength();
		// Form a String from the byte array.
		System.out.println("Elevator received:");
		Utility.printByteArray(data, len);
//		DatagramPacket sendReceivePacket = null;
//		try {
//			byte[] ackData = Message.ACK_MESSAGE.getBytes();
//			sendReceivePacket = new DatagramPacket(ackData, ackData.length, receivePacket.getAddress(),
//					receivePacket.getPort());
//
//			sendReceiveSocket.send(sendReceivePacket);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return Message.convertToMessage(data, receivePacket.getLength());

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
