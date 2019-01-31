import java.util.*;

public class Scheduler {

  private int PORT_FLOOR;
  private int PORT_ELEVATOR;
  private DatagramSocket socket_floor;
  private DatagramSocket socket_elevator;
  private InetAddress IPAddress;
  private Calendar cal;
  private SimpleDateFormat time;
  private DatagramPacket packet_floor;
  private DatagramPacket packet_elevator;
  private InetAddress holdAddressFloor;
  private int holdPortFloor;
  private InetAddress holdAddressElevator;
  private int holdPortElevator;

  public Scheduler() {}

  public void run() {}

  public static void main(String[] args) {}

}
