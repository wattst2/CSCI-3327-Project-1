import java.util.ArrayList;
import java.util.Collections;

//Goal: Determine the probability of any 2 people sharing a birthday in the class. *Read: Count how many people we are
//Program Requirements:
//• Make program flexible. Have user input for number of random people to create.
//• Make a Person class, with int birthday (Why does this make the problem easier?)
//• You can use MM/DD
//• You don't have to consider leap years.
//• Make sure you can configure the number of runs without touching your loop.
//Your main method should be able to control the run, determine class size and number of runs
//• Your main method should be in a separate class, with only object construction and run(x, y,z, etc)
public class BirthdayProgram {
	
	public ArrayList<String> personGenerator(int num) {
		ArrayList<String> birthdays = new ArrayList<String>();
		for(int i = 0; i < num; i++) {
			Person test = new Person();
			String birthday = test.getBirthday();
			birthdays.add(birthday);
		}
		return birthdays;
	}
	
	public double probCalculator(int userInputNum, int numOfRuns) {
		int count = 0;
		int runWin = 0;
		
		for(int i = 1; i <= numOfRuns; i++) {
			ArrayList<String> randomBirthdays = new ArrayList<>(personGenerator(userInputNum));
			Collections.sort(randomBirthdays);
			for(int j = 1; j < randomBirthdays.size(); j++) {
				if(randomBirthdays.get(j).equals(randomBirthdays.get(j - 1))) {
					count = 1;
					break;
				}
			}
			runWin += count;
			count = 0;
			randomBirthdays.clear();
		}
		return (double)runWin / (double)numOfRuns;
	}
}
