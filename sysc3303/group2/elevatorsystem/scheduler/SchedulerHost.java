package sysc3303.group2.elevatorsystem.scheduler;

import java.io.IOException;
import java.net.DatagramPacket;
/*	
 * Author: Hasan Issa
 * Contributors:
 * The networking part of the scheduler that communicates with the 
 * elevator and the floors
 */
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

import sysc3303.group2.elevatorsystem.common.Utility;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.NetworkUtility;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;

public class SchedulerHost {
	private int portNumber;
	private DatagramSocket hostSocket;
	private DatagramSocket sendReceiveSocket;
	private static final int BUFFER_SIZE = 1000;
	private int elevatorPort = 5001;
	private String elevatorIp = "127.0.0.1";
	private int floorPort = 5001;
	private String floorIp = "127.0.0.1";

	public SchedulerHost(int portNumber) throws SocketException {
		super();
		this.portNumber = portNumber;
		this.hostSocket = new DatagramSocket(portNumber);
		//this.hostSocket.setSoTimeout(250);
		this.sendReceiveSocket = new DatagramSocket();
	}

	public Message waitForANetworkRequest() {

		byte data[] = new byte[BUFFER_SIZE];
		DatagramPacket receivePacket = new DatagramPacket(data, data.length);

		// Block until a datagram packet is received from receiveSocket.
		try {
			hostSocket.receive(receivePacket);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int len = receivePacket.getLength();
		// Form a String from the byte array.
		System.out.println("Host received:");
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

	public int getPortNumber() {
		return portNumber;
	}

	public void sendCommandToElevator(RequestType requestType, Integer... parameters) {
		Message m = new Message();
		m.setRequestType(requestType);
		m.getParameters().addAll(Arrays.asList(parameters));
		NetworkUtility.sendData(sendReceiveSocket, m, elevatorIp, elevatorPort);
	}
	
	public void sendCommandToFloor(RequestType requestType, Integer... parameters) {
		Message m = new Message();
		m.setRequestType(requestType);
		m.getParameters().addAll(Arrays.asList(parameters));
		NetworkUtility.sendData(sendReceiveSocket, m, floorIp, floorPort);
	}

}
