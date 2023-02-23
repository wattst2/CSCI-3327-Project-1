import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
public class TestStatsLibrary {
	public static void main(String[] args) {
		StatsLibrary test = new StatsLibrary();
		//source: https://howtodoinjava.com/java/collections/arraylist/add-multiple-elements-arraylist/
		ArrayList<Double> someNumbers = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
		ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(2, 4, 6));
		ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(1, 2, 5, 7, 9));

		
		ArrayList<Integer> unionAB = test.findUnion(listA, listB);
		ArrayList<Integer> intersectionAB = test.findIntersection(listA, listB);
		ArrayList<Integer> complementA = test.findComplement(listA, set);
		System.out.println("Set = " + set);
		System.out.println("A = " + listA);
		System.out.println("B = " + listB);
		System.out.println("A U B = " + unionAB);
		System.out.println("A ⋂ B = " + intersectionAB);
		System.out.println("A' = " + complementA);
		
		double mean = test.findMean(someNumbers);//1+ 2+ 3+ 4 + 5 = 15 / 5 = expected = 3
		double median = test.findMedian(someNumbers);//[1, 2, 3, 4, 5] expected = 3
		Double mode = test.findMode(someNumbers);
		double stdDev = test.findStdDev(someNumbers);
		System.out.println("Mean of list " + someNumbers + ": " + mean);
		System.out.println("Median of list " + someNumbers + ": " + median);
		System.out.println("Mode of list " + someNumbers + ": " + mode);
		System.out.println("Standard deviation of list " + someNumbers + ": " + stdDev);
		BigInteger combo = test.solveCombo(10, 4);
		BigInteger perm = test.solvePerm(10, 4);
		System.out.println("Combo: " + combo);
		System.out.println("Perm: " + perm);
	}
}
