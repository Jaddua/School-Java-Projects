//ToDo: Supervisor wants programmer comments (use /* */ comment)

import java.util.Scanner;

//ToDo: Supervisor wants programmer comments (use /* */ comment)
public class User {
	
	private Scanner keyboard = new Scanner(System.in);
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public int inputInteger() {
		//ToDo: See lecture notes and stop this from crashing the program
		//      if the user enters text, you can copy and paste code from
		//      the lecture notes, but cite the lecture handout.
		int value = keyboard.nextInt();
		keyboard.nextLine();
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public int inputInteger(String message) {
		// This method calls inputInteger(), so no changes are needed here.
		System.out.printf("%s", message);
		int value = inputInteger(); 
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public double inputDouble() {
		//ToDo: See lecture notes and stop this from crashing the program
		//      if the user enters text, you can copy and paste code from
		//      the lecture notes, but cite the lecture handout.
		double value = keyboard.nextDouble();
		keyboard.nextLine();
		return value;	
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public double inputDouble(String message) {
		// This method calls inputDouble(), so no changes are needed here.
		System.out.printf("%s", message);
		double value = inputDouble();
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public String inputString() {
		String value = keyboard.nextLine();
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public String inputString(String message) {
		System.out.printf("%s", message);
		String value = inputString();
		return value;
	}
}