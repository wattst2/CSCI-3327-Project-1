package project1;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tests the DoorGame class and its methods.
 * @author Ta'Quawn Watts
 */

public class TestDoorGame {
	public static void main(String[] args) {
		DoorGame test = new DoorGame();
		ArrayList<String> Doors = new ArrayList<String>(Arrays.asList("Dud", "Dud", "Prize"));
		System.out.println(
				"Playing the door game 10,000 times, if you keep your original choice, the chances of a prize is: "
						+ test.keepDoor(Doors, 10000));
		System.out.println("If you decide to change your original choice, the chances of a prize is: "
				+ test.changeDoor(Doors, 10000));
	}
}