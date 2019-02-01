import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FloorClient {
	private int hostPort;
	private DatagramPacket sendPacket;
	private DatagramPacket receivePacket;
	private DatagramSocket sendReceiveSocket;
	
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
