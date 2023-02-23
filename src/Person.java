public class Person {
	private int month;
	private int day;
	private String birthday;
	private String formattedDay;
	private String formattedMonth;
	public Person() {
	//https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
		month = 1 + (int)(Math.random() * ((12 - 1) + 1));
		//https://www.geeksforgeeks.org/switch-statement-in-java/
		switch(month) {
		case 2:
			day = 1 + (int)(Math.random() * ((28 - 1) + 1));
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 1 + (int)(Math.random() * ((31 - 1) + 1));
			break;
		default:
			day = 1 + (int)(Math.random() * ((30 - 1) + 1));
			break;
		}
		
		if(day < 10) {
			formattedDay = String.format("%02d", day);
		} else {
			formattedDay = Integer.toString(day);
		}
		
	//https://www.tutorialspoint.com/java-program-to-add-leading-zeros-to-a-number
		if(month < 10) {
			formattedMonth = String.format("%02d", month);
		} else {
			formattedMonth = Integer.toString(month);
		}
		
		birthday = formattedMonth + "/" + formattedDay;
	}
	
	public String getBirthday() {
		return birthday;
	}
}
