package sysc3303.group2.elevatorsystem.common.networking;

/*	
 * Author: George 
 * Contributors:Hasan Issa
 * 
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class Message {

	public static final String ACK_MESSAGE = "ACK";

	private RequestType requestType;

	/**
	 * Designed to only have a single parameter for now
	 */
	private int parameter;

	public Message() {
	}

	public byte[] convertToByteArray() {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		buffer.write(requestType.getCommandNumber());
		buffer.write(parameter);
		// String fileName = "random.txt";
		// buffer.write(fileName.getBytes());
		//buffer.write(0);
		return buffer.toByteArray();
	}

	public static Message convertToMessage(byte[] data) {
		Message m = new Message();
		m.setParameter(data[1]);
		m.setRequestType(RequestType.getByCommandNumber(data[0]));
		return m;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		this.parameter = parameter;
	}

}
