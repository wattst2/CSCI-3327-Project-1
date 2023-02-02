import java.util.ArrayList;

public class TestSetOperations {

	public static void main(String[] args) {
		SetOperations test = new SetOperations();
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		listA.add(2);
		listA.add(4);
		listA.add(6);
		
		listB.add(1);
		listB.add(2);
		listB.add(4);
		listB.add(5);
		listB.add(7);
		listB.add(9);
		
		ArrayList<Integer> unionAB = test.findUnion(listA, listB);
		ArrayList<Integer> intersectionAB = test.findIntersection(listA, listB);
		System.out.println("A = " + listA);
		System.out.println("B = " + listB);
		System.out.println("A U B = " + unionAB);
		System.out.println("A N B = " + intersectionAB);
	}

}
