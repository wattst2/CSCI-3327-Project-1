/**
 * 
 * @author Ta'Quawn Watts
 *
 */
import java.util.ArrayList;
import java.util.Collections;
public class SetOperations {
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
		ArrayList<Integer> intersectionAB = new ArrayList<>();
		Collections.sort(listA);
		Collections.sort(listB);
		for(int i = 0; i < listA.size(); i++) {
			for(int j = 0; i < listB.size(); j++) {
				if(listA.get(i) == listB.get(j)) {
					intersectionAB.add(listA.get(i)); {
				}
				if(i < listB.size()) {
					break;
				}
				}
			}
		}
		return intersectionAB;
	}
}
