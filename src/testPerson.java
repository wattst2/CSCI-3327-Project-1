public class testPerson {
	public static void main(String[] args) {
		for(int i = 1; i < 31; i++) {
			Person test = new Person();
			System.out.println("Person " + i + ": " + test.getBirthday());
		}
		
	}
}
