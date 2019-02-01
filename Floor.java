import java.util.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Floor {

  private int PORT;
  private String FILE_NAME;
  private DatagramSocket socket;
  private DatagramPacket packet;
  private Calendar cal;
  private SimpleDateFormat time;
  private InetAddress IPAddress;
  private InetAddress holdAddress;
  private int holdPort;

  public Floor() {}

  public void sendAndReceive(String command) {}

  public void run() {}

  public static void main(String[] args) {}

}
