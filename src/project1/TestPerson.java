package project1;

/**
 * 
 * Tests the Person class and its function. Creates 30 Person objects and prints
 * out each birthday.
 * 
 * @author Ta'Quawn Watts
 */

public class TestPerson {
	public static void main(String[] args) {
		for (int i = 1; i < 31; i++) {
			Person test = new Person();
			System.out.println("Person " + i + ": " + test.getBirthday());
		}

	}
}
