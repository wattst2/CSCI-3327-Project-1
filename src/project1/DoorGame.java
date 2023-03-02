package project1;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Determines the probabilities of the "Door Game". The game goes as following: 
 * 
 * "The following game was played on a popular television show. The host showed a contestant three large curtains. 
 * Behind one of the curtains was a nice prize (maybe a new car) and behind the other two curtains were worthless 
 * prizes (duds). The contestant was asked to choose one curtain. Before showing the 
 * contestant what was behind the curtain initially chosen, the game show host would open one of the curtains 
 * and show the contestant one of the duds. He then offered the contestant the option 
 * of changing from the curtain initially selected to the other remaining unopened curtain. Which strategy 
 * maximizes the contestant’s probability of winning the good prize: stay with the initial choice or 
 * switch to the other curtain?
 * 
 * 1.) The simple events probabilities would be: P(D1) = P(D2) = P(P) = 1/3
 * 2a.) The probability of winning the good prize is 1/3.
 * 2b.) If the contestant is shown a dud and she selected P, they will switch to a dud.
 * 2c.) If the contestant is shown a dud and she selected D, they will switch to a prize.
 * 2d.) If the contestant switches their door, the chances of a prize is 2/3.
 * 2e.) Switching doors is the best strategy.
 */

public class DoorGame {

	/**
	 * 
	 * @param doorChoices is a list of the possible prizes the contestant can find.
	 * @param numOfRuns   is the integer type number of runs to complete.
	 * @return The probability of winning the "nice prize" if the contestant decides
	 *         to keep their door.
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/62438100/string-decimal-to-percentage-in-java">Decimal
	 *      to percentage source</a>
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java">Generating
	 *      a random range source</a>
	 */

	/*
	 * After shuffling all of the doors, a random door is picked. The contestant
	 * chooses to keep their door. If the "nice prize" is behind the door, then one
	 * is added to runWin. After reaching the desired runs, it calculates the
	 * probability of getting a "nice prize" after keeping your original door.
	 */
	public String keepDoor(ArrayList<String> doorChoices, int numOfRuns) {
		double runWin = 0;
		for (int i = 0; i < numOfRuns; i++) {
			Collections.shuffle(doorChoices);
			int doorNumber = 0 + (int) (Math.random() * ((2 - 0) + 1));
			if (doorChoices.get(doorNumber).equals("Prize")) {
				runWin++;
			}
		}
		double prob = (runWin / (double) numOfRuns) * 100;
		return String.format("%.2f%%", prob);
	}

	/**
	 * 
	 * @param doorChoices is a list of the possible prizes the contestant can find.
	 * @param numOfRuns   is the integer type runs to complete.
	 * @return The probability of receiving the "nice prize" if the contestant
	 *         changes their door.
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/62438100/string-decimal-to-percentage-in-java">Decimal
	 *      to percentage source</a>
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java">Generating
	 *      a random range source</a>
	 */
	public String changeDoor(ArrayList<String> doorChoices, int numOfRuns) {
		double runWin = 0;

		/*
		 * After shuffling all of the doors, changeDoor selects a random one. The
		 * contestant is shown a dud door. If the door originally selected contained a
		 * dud, then after changing the doors, the contestant would select the
		 * "nice prize" door. changeDoor adds one to the runWin. After reaching the
		 * desired runs, it calculates the probability of receiving the "nice prize"
		 * after changing doors.
		 */
		for (int i = 0; i < numOfRuns; i++) {
			Collections.shuffle(doorChoices);
			int choice = 0 + (int) (Math.random() * ((2 - 0) + 1));
			String result = doorChoices.get(choice);
			if (result.equals("Dud")) {
				runWin++;
			}
		}
		double prob = (runWin / (double) numOfRuns) * 100;
		return String.format("%.2f%%", prob);

	}
}
