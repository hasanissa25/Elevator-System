package sysc3303.group2.elevatorsystem.common.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtility {
	public static void sendData(DatagramSocket s, Message m, String hostIp, int hostPort) {
		byte data[] = m.convertToByteArray();
		try {
			DatagramPacket sendPacket = new DatagramPacket(data, data.length, InetAddress.getByName(hostIp), hostPort);
			s.send(sendPacket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
