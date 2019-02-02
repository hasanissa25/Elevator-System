/*	
 * Author: Hasan Issa
 * Contributors:
 * This is the network client that sends the request over the network to the scheduler
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class FloorClient {
	private int hostPort;
	private String hostIp;
	private DatagramPacket sendPacket;
	private DatagramPacket receivePacket;
	private DatagramSocket sendReceiveSocket;
	
	public FloorClient(int hostPort, String ip) {
		this.hostPort = hostPort;
		this.hostIp= ip;
		try {
			this.sendReceiveSocket= new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public int getHostPort() {
		return hostPort;
	}
	
	public void setHostPort(int hostPort) {
		this.hostPort = hostPort;
	}
	public DatagramPacket getSendPacket() {
		return sendPacket;
	}
	public void setSendPacket(DatagramPacket sendPacket) {
		this.sendPacket = sendPacket;
	}
	public DatagramPacket getReceivePacket() {
		return receivePacket;
	}
	public void setReceivePacket(DatagramPacket receivePacket) {
		this.receivePacket = receivePacket;
	}
	public DatagramSocket getSendReceiveSocket() {
		return sendReceiveSocket;
	}
	public void setSendReceiveSocket(DatagramSocket sendReceiveSocket) {
		this.sendReceiveSocket = sendReceiveSocket;
	}
	
	public void connectToElevator() {}
	public void sendFloorButtonRequest(Direction direction,int destinationFloor) {}
}
