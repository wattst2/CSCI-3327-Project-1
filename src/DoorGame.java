import java.util.ArrayList;
import java.util.Collections;
public class DoorGame {
	public String keepDoor(ArrayList<String> doorChoices, int num) {
		double runWin = 0;
		for(int i = 0; i < num; i++) {
			Collections.shuffle(doorChoices);
			int doorNumber = 0 + (int)(Math.random() * ((2 - 0) + 1));
			if(doorChoices.get(doorNumber).equals("Prize")) {
				runWin++;
			}
		}
		double prob = (runWin/(double)num) * 100;
		return String.format("%.2f%%", prob);
	}
	
	public String changeDoor(ArrayList<String> doorChoices, int num) {
		double runWin = 0;
		for(int i = 0; i < num; i++) {
			Collections.shuffle(doorChoices);
			int choice = 0 + (int)(Math.random() * ((2 - 0) + 1));
			String result = doorChoices.get(choice);
			if(result.equals("Dud")) {
				runWin++;
			}
		}
		double prob = (runWin/(double)num) * 100;
		return String.format("%.2f%%", prob);

	}
}
