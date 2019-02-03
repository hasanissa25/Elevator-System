package sysc3303.group2.elevatorsystem.floor;

import java.io.IOException;
/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the network client that sends the request over the network to the scheduler
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.NetworkUtility;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;

public class FloorClient {
	private static final int BUFFER_SIZE = 100;
	private int hostPort;
	private String hostIp;
	private DatagramPacket receivePacket;
	private DatagramSocket sendReceiveSocket;

	public FloorClient(int hostPort, String ip) {
		this.hostPort = hostPort;
		this.hostIp = ip;
		try {
			this.sendReceiveSocket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHostIp() {
		return hostIp;
	}

	public int getHostPort() {
		return hostPort;
	}

	public void connectToElevator() {
	}

	public void sendFloorButtonRequest(Direction direction, int sourceFloor) {
		Message s = new Message();
		s.getParameters().add(sourceFloor);
		s.setRequestType(direction == Direction.UP ? RequestType.floorButtonUp : RequestType.floorButtonDown);
		NetworkUtility.sendData(sendReceiveSocket, s, hostIp, hostPort);
	}

	

		// wait for an acknowledge signal back
		/*
		data = new byte[BUFFER_SIZE];
		receivePacket = new DatagramPacket(data, data.length);

		try {
			// Block until a datagram is received via sendReceiveSocket.
			sendReceiveSocket.receive(receivePacket);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		String received = new String(data, 0, receivePacket.getLength());
		if (Message.ACK_MESSAGE.equals(received))
			return true;
		else
			return false;
			*/
	
	
}
