import java.util.Scanner;
public class testBirthdayProgram {
	public static void main(String[] args) {
		BirthdayProgram test = new BirthdayProgram();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the amount of people in each class: ");
		int num = scan.nextInt();
		System.out.println("Enter the amount of runs would you like to execute: ");
		int runs = scan.nextInt();
		scan.close();
		double prob = test.probCalculator(num, runs) * 100;
		//https://stackoverflow.com/questions/62438100/string-decimal-to-percentage-in-java
		String formattedProb = String.format("%.2f%%", prob);
		System.out.println("Running this experiment " + runs + " times, the probability of any two people in a class of 30 is: " + formattedProb);
	}

}
