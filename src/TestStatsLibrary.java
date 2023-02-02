import java.util.ArrayList;
public class TestStatsLibrary {
	public static void main(String[] args) {
		StatsLibrary test = new StatsLibrary();
		ArrayList<Double> someNumbers = new ArrayList<>();
		someNumbers.add(1.0);
		someNumbers.add(2.0);
		someNumbers.add(3.0);
		someNumbers.add(4.0);
//		someNumbers.add(5);
		double mean = test.findMean(someNumbers);//1+ 2+ 3+ 4 + 5 = 15 / 5 = expected = 3
		double median = test.findMedian(someNumbers);//[1, 2, 3, 4, 5] expected = 3
		Double mode = test.findMode(someNumbers);
		double stdDev = test.findStdDev(someNumbers);
		System.out.println("Mean of list " + someNumbers + ": " + mean);
		System.out.println("Median of list " + someNumbers + ": " + median);
		System.out.println("Mode of list " + someNumbers + ": " + mode);
		System.out.println("Standard deviation of list " + someNumbers + ": " + stdDev);
	}
}
