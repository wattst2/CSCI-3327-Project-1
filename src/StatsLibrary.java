/**
 * author: Ta'Quawn Watts
 */



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
}
