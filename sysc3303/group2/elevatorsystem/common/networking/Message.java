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

	private List<Integer> parameters;

	public Message() {
		parameters = new ArrayList<>();
	}

	public byte[] convertToByteArray() {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		buffer.write(requestType.getCommandNumber());
		for(Integer parameter : parameters) {
			buffer.write(parameter);
		}
		// String fileName = "random.txt";
		// buffer.write(fileName.getBytes());
		//buffer.write(0);
		return buffer.toByteArray();
	}

	public static Message convertToMessage(byte[] data, int length) {
		Message m = new Message();
		for(int i = 1; i < length; i++) {
			m.getParameters().add((int) data[i]);
		}
		m.setRequestType(RequestType.getByCommandNumber(data[0]));
		return m;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public List<Integer> getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return "Message [requestType=" + requestType + ", parameters=" + parameters + "]";
	}



}
