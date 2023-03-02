package project1;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Determines the probability of any two people in a classroom sharing a birthday.
 * @author Ta'Quawn Watts
 */

public class BirthdayProgram {

	/**
	 * 
	 * @param num is the integer type number of Person objects to create
	 * @return A list of randomized birthdays See {@link Person#getBirthday()
	 *         getBirthday} method to get randomized birthday
	 */
	public ArrayList<String> personGenerator(int num) {
		ArrayList<String> birthdays = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			Person test = new Person();
			String birthday = test.getBirthday();
			birthdays.add(birthday);
		}
		return birthdays;
	}

	/**
	 * 
	 * @param userInputNum is the integer type number of Person objects to create.
	 * @param numOfRuns    is the integer type number of runs to complete.
	 * @return The probability of two duplicate birthdays being generated. Uses
	 *         {@link #personGenerator(int)}  to generate desired number of Person
	 *         objects.
	 */
	public double probCalculator(int userInputNum, int numOfRuns) {
		int count = 0;
		int runWin = 0;

		/*
		 * After creating and sorting the randomBirthdays list, probCalculator checks
		 * the list for any duplicate birthdays. If there are any duplicates, it sets
		 * count to one and breaks the nested for loop. probCalculator adds count to
		 * runWin, resets count back to zero, clears the randomBirthdays list and
		 * continues the loop until the desired number of runs is reached. Afterwards,
		 * it returns the number of wins (runWins) divided by the number of runs
		 * (numOfRuns).
		 */
		for (int i = 1; i <= numOfRuns; i++) {
			ArrayList<String> randomBirthdays = new ArrayList<>(personGenerator(userInputNum));
			Collections.sort(randomBirthdays);
			for (int j = 1; j < randomBirthdays.size(); j++) {
				if (randomBirthdays.get(j).equals(randomBirthdays.get(j - 1))) {
					count = 1;
					break;
				}
			}
			runWin += count;
			count = 0;
			randomBirthdays.clear();
		}
		return (double) runWin / (double) numOfRuns;
	}
}
