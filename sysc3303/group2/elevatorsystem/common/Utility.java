package sysc3303.group2.elevatorsystem.common;

public class Utility {
	public static void printByteArray(byte[] buffer, int dataLength) {
		for (int i = 0; i < dataLength; i++) {
			System.out.print(buffer[i] + " ");
		}
		System.out.println();
	}
}
