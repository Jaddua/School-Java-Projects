/* Exercise 06 (21F) 
 * Author: Stanley Pieda
 * Modified By: Jaddua Jones
 * Lab Professor: Siju Phillip
 * November 26 2021
 */

/*
 * This is the driver class to run the program.
 */
public class Exercise06 {

	/*
	 * This is the main method to run the program.
	 */
	public static void main(String[] args) {
		final int ENCODE = 1;
		final int DECODE = 2;
		final int EXIT = 0;
		int option = 0;
		String userText = "";
		String formatString = "%d %s%n";
		SimpleCipher cipher = new SimpleCipher();
		do {
			System.out.printf(formatString, ENCODE, 
					"to encode text");
			System.out.printf(formatString, DECODE,
					"to decode text");
			System.out.printf(formatString, EXIT,
					"to exit program");
			option = User.inputInteger("Enter option: ");
			switch(option) {
			case ENCODE:
				userText = User.inputString("Enter text to encode ");
				userText = cipher.encode(userText);
				System.out.printf("result:%n%s%n", userText);
				break;
			case DECODE:
				userText = User.inputString("Enter text to decode ");
				userText = cipher.decode(userText);
				System.out.printf("result:%n%s%n", userText);
				break;
			case EXIT:
				System.out.printf("%s%n", "Program will exit now.");
				break;
			default:
				System.out.printf("%s%n", "Invalid Option.");
				break;
			}
		} while(option != 0);
		System.out.println("Jaddua Jones");
		// update the program so it outputs your name as seen in ACSIS.
	}
}
