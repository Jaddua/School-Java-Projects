//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*Jaddua Jones CST_8116 363 Assignment 02*/
import java.util.Scanner;
//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*class for Assignment 02 to run the code*/
public class Assignment02 {

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*main method to run the program*/
	public static void main(String[] args) {
		DrinkMachine machine = new DrinkMachine();
		User user = new User();
		while (true) {
			machine.setSize(user.inputString("Please choose a drink size as text from the following menu. \n" + machine.drinkSizeMenu() + "\n"));
		
			machine.setVolume(user.inputDouble("Please give the measured volume, decimal places are accepted. \n"));
			System.out.println(machine.verifySize());
			System.out.println("Jaddua Jones");
			if (!user.inputString("Is there any more data to enter? (yes / no) \n").toLowerCase().equals("yes"))
				break;
		}
		System.out.println("Program finished.");
		// (other variables as needed)
		
		// ToDo:
		// Ask for drink size as text, prompt using the menu generated
		// from a method in DrinkMachine
		
		// Ask for measured volume, accepting decimal places
		
		// determine if the volume matches the expected size using the
		// verifySize() method, printing the returned report.
		
		// print out your name on screen
		
		// ask if there is more data to enter (yes, no) and continue
		// using a loop only if the user enters some form of yes
		// e.g. "YES" "yEs" "yeS" would be acceptable (any capitalization)
		
		// you can use any decision structure or loop for this program,
		// however a for-loop is not recommended.
		
		

	}
}