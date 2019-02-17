package sysc3303.group2.elevatorsystem.scheduler.test;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.NetworkUtility;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;
import sysc3303.group2.elevatorsystem.scheduler.Scheduler;

public class SchedulerTest {

	private Scheduler scheduler;
	private Thread schedulerThread;
	private final static int TEST_PORT = 6000;
	
	@Before
	public void setup() throws SocketException, UnknownHostException {
		this.scheduler = new Scheduler(TEST_PORT);
		this.schedulerThread = new Thread(this.scheduler, "TestSchedulerThread");
		this.schedulerThread.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		this.scheduler.shutdown();
		this.schedulerThread.join();
	}
	
	@Test
	public void testSendValidFloorButtonRequest() throws UnknownHostException, SocketException {
		DatagramSocket s = new DatagramSocket();
		Message message = new Message();
		//Message m = new FloorUpRequestMessage();
		message.getParameters().add(1);
		//m.setCurrentFloorOn()
		message.setRequestType(RequestType.floorButtonUp);
		NetworkUtility.sendData(s, message, InetAddress.getLocalHost().getHostAddress(), TEST_PORT);
		
		
	}
	
	@Test
	public void testSendInvalidFloorButtonRequest() {
		
	}
	
	@Test
	public void testSendValidFloorButtonRequestToFloor3_5floorBuilding() {
		
	}
	
}
