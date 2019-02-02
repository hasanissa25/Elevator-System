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

  private RequestType requestType;
  
  /**
   * Designed to only have a single parameter for now
   */
  private String parameter;

  public Message() {}

  public byte[] convertToByteArray() {
	  return null;
  }
  
  public static Message convertToMessage(byte[] data) {
	  return new Message();
  }
}
