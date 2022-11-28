//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*Jaddua Jones CST_8116 363 Assignment 02*/
import java.util.Scanner;

//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*class of User to take user input*/
public class User {
	
	private Scanner keyboard = new Scanner(System.in);
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*method to input an integer*/
	public int inputInteger() {
		//ToDo: See lecture notes and stop this from crashing the program
		//      if the user enters text, you can copy and paste code from
		//      the lecture notes, but cite the lecture handout.
		while(!keyboard.hasNextInt()) {
			System.out.println("Please only enter an integer. No text or numbers with fractional parts.");
			keyboard.nextLine();	
		}
		int value = keyboard.nextInt();
		keyboard.nextLine();
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*method to input an integer*/
	public int inputInteger(String message) {
		// This method calls inputInteger(), so no changes are needed here.
		System.out.printf("%s", message);
		int value = inputInteger(); 
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*method to input a double*/
	public double inputDouble() {
		//ToDo: See lecture notes and stop this from crashing the program
		//      if the user enters text, you can copy and paste code from
		//      the lecture notes, but cite the lecture handout.
		while(!keyboard.hasNextDouble()) {
			System.out.println("Please only enter a number. No text.");
			keyboard.nextLine();	
		}
		double value = keyboard.nextDouble();
		keyboard.nextLine();
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*method to input a double*/
	public double inputDouble(String message) {
		// This method calls inputDouble(), so no changes are needed here.
		System.out.printf("%s", message);
		double value = inputDouble();
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*method to input a string*/
	public String inputString() {
		String value = keyboard.nextLine();
		return value;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*method to input a string*/
	public String inputString(String message) {
		System.out.printf("%s", message);
		String value = inputString();
		return value;
	}
}