import java.util.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Floor {

	private int floorNumber;
	
	public void handleButtonPressed(Direction direction) {}
	public void pressFloorDownBottom(){}
	public void pressFloorUpBottom(){}
	public void pressFloorUp(int currentFloorNumber) {}
	public boolean getFloorUpLampStatus() {
		return false;
	}
	public boolean getFloorDownLampStatus() {
		return false;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	} 
}
