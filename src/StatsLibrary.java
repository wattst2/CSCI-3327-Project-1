/**
 * author: Ta'Quawn Watts
 */


import java.lang.Math;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
public class StatsLibrary {
	
	/**
	 * 
	 * @param inputNumbers is the list 
	 * @return The mean of the list
	 */
	public double findMean(ArrayList<Double> inputNumbers) {
		double sum = 0;
		//for each singleElement in inputNumbers arraylist
		for(double singleElement : inputNumbers) {
			sum = sum + singleElement;
		}
		double result = sum / inputNumbers.size();
		return result;
	}
	
	/**
	 * 
	 * @param inputNumbers is the list
	 * @return the median of the list
	 */
	
	public double findMedian(ArrayList<Double> inputNumbers) {
		//sorts the list in ascending order
		Collections.sort(inputNumbers);
		double result;
		int middle;
		//if the size of list is even
		if(inputNumbers.size() % 2 == 0) {
			//adds the two middle numbers
			result = inputNumbers.get((inputNumbers.size() / 2) - 1) + inputNumbers.get((inputNumbers.size() / 2));
			result = result / 2;
			return result;
		} else {
			middle = inputNumbers.size() / 2;
			return inputNumbers.get(middle);
		}
	}
	
	/**
	 * 
	 * @param inputNumbers is the list
	 * @return the mode of the list
	 */
	public double findMode(ArrayList<Double> inputNumbers) {
		Collections.sort((inputNumbers));
		int count = 1;
		int maxCount = 1;
		int modeCount = 0;
		Double mode = (double)inputNumbers.get(0);
		for(int i = 1; i < inputNumbers.size(); i++) {
			if(inputNumbers.get(i) == inputNumbers.get(i - 1)) {
				count++;
			} else {
				if(count > maxCount) {
					maxCount = count;
					mode = (double)inputNumbers.get(i - 1);
					modeCount++;
				}
				count = 1;
			}
		}
		if (count > maxCount) {
			mode = (double)inputNumbers.get(inputNumbers.size() - 1);
		   }
		if ((modeCount > 1) & (modeCount == 0))  {
			mode = null;
		}
		return mode;
	}
	
	/**
	 * 
	 * @param inputNumbers is the list
	 * @return the standard deviation of the list
	 */
	
	public double findStdDev(ArrayList<Double> inputNumbers) {
		//finds mean of list
		double mean = findMean(inputNumbers);
		double sum = 0;
		double dev = 0;
		double result = 0;
		//Creates a clone of the inputNumbers list so we are not changing the original's elements
		//source where I learned this: https://www.baeldung.com/java-copy-list-to-another
		ArrayList<Double> devCopy = new ArrayList<>(inputNumbers);
		//subtracts the mean from each element of copy list and sets it as the new element
		for(int i = 1; i < devCopy.size(); i++) {
			double subtractMean = devCopy.get(i) - mean;
			devCopy.set(i, subtractMean);
		}
		//squares each element and sets it as the new element
		for(int i = 1; i < devCopy.size(); i++) {
			double square = Math.pow(devCopy.get(i), 2);
			devCopy.set(i, square);
		}
		
		//adds each element up and saves it as the variable sum
		for(double singleElement : devCopy) {
			sum = sum + singleElement;
		}
		
		dev = sum / (devCopy.size() - 1);
		result = Math.sqrt(dev);
		return result;
	}
	
	public ArrayList<Integer> findUnion(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		//creates a new list that will be the union of A and B
		ArrayList<Integer> unionAB = new ArrayList<>();
		//adds all of A to union list
		unionAB.addAll(listA);
		//adds all of B to union list
		unionAB.addAll(listB);
		//sorts the union list so we can find any duplicates
		Collections.sort(unionAB);
		//using a for loop, we go through the sorted union list. if the element is the same as the one before it, we remove the duplicate.
		for(int i = 1; i < unionAB.size(); i++) {
			if(unionAB.get(i) == unionAB.get(i - 1)) {
				unionAB.remove(i);
			}
		}
		//return the union set
		return unionAB;
	}
	
	public ArrayList<Integer> findIntersection(ArrayList<Integer> listA, ArrayList<Integer> listB) {
		//creates a new arraylist that will contain the intersection of A and B
		ArrayList<Integer> intersectionAB = new ArrayList<>();
		//sorts both lists
		Collections.sort(listA);
		Collections.sort(listB);
		//checks listA with looks for matches with list B
		for(int i = 0; i < listA.size(); i++) {
			for(int j = 0; j < listB.size(); j++) {
				//if there is a match, add the element to the intersection arraylist
				if(listA.get(i) == listB.get(j)) {
					intersectionAB.add(listA.get(i));
					break;
				}
			}
		}
		return intersectionAB;
	}
	
	public ArrayList<Integer> findComplement(ArrayList<Integer> list, ArrayList<Integer> set) {
		ArrayList<Integer> listComplement = new ArrayList<>(set);
		Collections.sort(list);
		Collections.sort(set);
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < set.size(); j++) {
				if(list.get(i) == set.get(j)) {
					listComplement.remove(list.get(i));
					break;
				}
			}
		}
		return listComplement;
	}
	
	//sources: 
	//https://www.javatpoint.com/factorial-program-in-java
	//https://www.geeksforgeeks.org/biginteger-class-in-java/
	
	public BigInteger factorial(int i) {
		if (i == 0) {
			return BigInteger.ONE;
		} else {
			BigInteger b = BigInteger.valueOf(i);
			return b.multiply(factorial(i - 1));
		}
	}
	
	public BigInteger solveCombo(int n, int r) {
		if (r > n) {
			return BigInteger.ZERO;
		}
		
		BigInteger nFact = factorial(n);
		BigInteger denom = factorial(n - r).multiply(factorial(r));
		return nFact.divide(denom);
	}
	
	public BigInteger solvePerm(int n, int r) {
		if (r > n) {
			return BigInteger.ZERO;
		}
		BigInteger nFact = factorial(n);
		BigInteger denom = factorial(n - r);
		return nFact.divide(denom);
	}
	
//	public BigInteger solveBinoDistrib(int n, int y, double p) {
//		BigInteger combo = solveCombo(n, y);
//		double q = p - 1;
//		double pVar = Math.pow(p, y);
//		double yVar = Math.pow(y, p);
//		return combo.multiply(pVar);
//	}
//	
//	
}
