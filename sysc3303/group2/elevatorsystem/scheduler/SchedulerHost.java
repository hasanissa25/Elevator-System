package sysc3303.group2.elevatorsystem.scheduler;
/*	
 * Author: Hasan Issa
 * Contributors:
 * The networking part of the scheduler that communicates with the 
 * elevator and the floors
 */
import java.net.DatagramSocket;

public class SchedulerHost {
	private int portNumber;
	private DatagramSocket hostSocket;

	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	public DatagramSocket getHostSocket() {
		return hostSocket;
	}
	public void setHostSocket(DatagramSocket hostSocket) {
		this.hostSocket = hostSocket;
	}
	
	public void turnOffElevatorLamp(int floorNumber) {}
	public void openDoor() {};
	public void closeDoor() {};
	public void motorUp() {};
	public void motorDown() {};
	public void motorStop() {};

}
