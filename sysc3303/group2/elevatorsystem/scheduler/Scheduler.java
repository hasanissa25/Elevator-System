package sysc3303.group2.elevatorsystem.scheduler;

/*	
 * Author: Hasan Issa
 * Contributors:
 * This schedules the events and floor requests and elevator requests and ensures safety of the entire system
 */
import java.util.*;

import sysc3303.group2.elevatorsystem.common.Direction;
import sysc3303.group2.elevatorsystem.common.networking.Message;
import sysc3303.group2.elevatorsystem.common.networking.RequestType;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Scheduler implements Runnable {

	private static final int DEFAULT_HOST_PORT = 5000;

	private SchedulerHost schedulerHost;

	private boolean isCurrentlyProcessing;

	public Scheduler() throws SocketException {
		schedulerHost = new SchedulerHost(DEFAULT_HOST_PORT);
	}

	public Scheduler(int schedulerPort) throws SocketException {
		schedulerHost = new SchedulerHost(schedulerPort);
	}

	@Override
	public void run() {
		while (true) {
			Message m = schedulerHost.waitForANetworkRequest();
			if(m== null) continue;
			switch (m.getRequestType()) {
			case floorButtonDown:
				processFloorButtonRequest(Direction.DOWN, m.getParameter());
				break;
			case floorButtonUp:
				processFloorButtonRequest(Direction.UP, m.getParameter());
				break;
			case arrivalSensorMovingDown:
				break;
			case arrivalSensorMovingUp:
				break;
			case elevatorDoorClose:
				break;
			case elevatorDoorOpen:
				break;
			case moveMotorDown:
				break;
			case moveMotorIdle:
				break;
			case moveMotorUp:
				break;
			default:
				break;
			}
		}
	}

	private void processFloorButtonRequest(Direction direction, int floorNumberThatPressedButton) {
		System.out.println("Scheduler: Processing floor button request: " + floorNumberThatPressedButton );
	}

	public static void main(String[] args) throws SocketException {
		Scheduler s = new Scheduler();
		s.run();
	}

	public boolean isCurrentlyProcessing() {
		return isCurrentlyProcessing;
	}

	public void setCurrentlyProcessing(boolean isCurrentlyProcessing) {
		this.isCurrentlyProcessing = isCurrentlyProcessing;
	}

}
