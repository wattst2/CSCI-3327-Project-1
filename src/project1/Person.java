package project1;

/**
 * Represents a person with a randomized birthday.
 * 
 * @author Ta'Quawn Watts
 *
 */

public class Person {
	private int month;
	private int day;
	private String birthday;
	private String formattedDay;
	private String formattedMonth;

	/**
	 * 
	 * Creates a Person object.
	 * 
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java">Generating
	 *      a random range source</a>
	 * @see <a href="https://www.geeksforgeeks.org/switch-statement-in-java/">Switch
	 *      and case source</a>
	 * @see <a href=
	 *      "https://www.tutorialspoint.com/java-program-to-add-leading-zeros-to-a-number">Leading
	 *      0's source</a>
	 */
	public Person() {

		/*
		 * Generates a random number between 1-12 for the month. It generates the
		 * correct number of days for the month. For example, if the random month
		 * generated is the second month (February), it will generate a random number in
		 * the range 1-28.
		 */
		month = 1 + (int) (Math.random() * ((12 - 1) + 1));

		switch (month) {
		case 2:
			day = 1 + (int) (Math.random() * ((28 - 1) + 1));
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 1 + (int) (Math.random() * ((31 - 1) + 1));
			break;
		default:
			day = 1 + (int) (Math.random() * ((30 - 1) + 1));
			break;
		}

		if (day < 10) {
			formattedDay = String.format("%02d", day);
		} else {
			formattedDay = Integer.toString(day);
		}

		if (month < 10) {
			formattedMonth = String.format("%02d", month);
		} else {
			formattedMonth = Integer.toString(month);
		}

		birthday = formattedMonth + "/" + formattedDay;
	}

	/**
	 * 
	 * @return The birthday of a Person
	 */
	public String getBirthday() {
		return birthday;
	}
}
