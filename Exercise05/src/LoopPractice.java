/* Programmer comments here for file-header */
/*Jaddua Jones CST8116_363 Lab 5
 * Lab Professor: Siju Phillip
 */
/* Programmer comments here for class overview */
//class for testing loops
public class LoopPractice {
	
	private User user = new User(); // use this to get inputs
	
	/* Programmer comments here for method overview */
	//method for testing while loops
	public void testWhileLoopProblem() {
		double sum = 0;
		double average = 0;
		int numberCounter = 0;
		String shouldContinue = "yes";
		System.out.printf("%s%n", "Indeterminate while loop demo");
		//ToDo: Part 1: indeterminate loop
		// prompt user for a number
		// add their input to sum
		// ask if they want to enter more numbers
		// get their response
		// repeat the steps until they enter something that is not "yes"
		// use a while loop.
		// output the resulting sum using printf, format to 4 decimal places
		// output the resulting average using printf, format to 4 decimal places
		// output your name using printf
		while (shouldContinue.equals("yes")) {
			sum = sum + user.inputDouble("Enter a number please.\n");
			numberCounter++;
			shouldContinue = user.inputString("Would you like to enter more numbers? (yes / no)\n");
		}
		average = sum / numberCounter;
		System.out.printf("The total sum is: %.4f.%nThe average of all the numbers is: %.4f.%nJaddua Jones%n", sum, average);
	}
	
	/* Programmer comments here for method overview */
	//method for testing do-while loops
	public void testDoWhileLoopProblem() {
		double sum = 0;
		double average = 0;
		int numberCounter = 0;
		String shouldContinue = "yes";
		System.out.printf("%s%n", "Indeterminate do-while loop demo");
		//ToDo: Part 2: indeterminate loop
		// prompt user for a number
		// add their input to sum
		// ask if they want to enter more numbers
		// get their response
		// repeat the steps until they enter something that is not "yes"
		// **use a do-while loop instead**
		// output the resulting sum using printf, format to 4 decimal places
		// output the resulting average using printf, format to 4 decimal places
		// output your name using printf
		// you may re-use your code from part 1 with changes for do-while loop
		do {
			sum = sum + user.inputDouble("Enter a number please.\n");
			numberCounter++;
			shouldContinue = user.inputString("Would you like to enter more numbers? (yes / no)\n");
		} while (shouldContinue.equals("yes"));
		average = sum / numberCounter;
		System.out.printf("The total sum is: %.4f.%nThe average of all the numbers is: %.4f.%nJaddua Jones%n", sum, average);
	
	}
	
	/* Programmer comments here for method overview */
	//method for testing for loops
	public void testForLoopProblem() {
		String sentence = "";
		int letterCount = 0;
		char extractedCharacter = 0;
		System.out.printf("%s%n", "Determinate for loop demo");
		// ToDo: Part 3: determinate loop
		// prompt the user to enter a sentence
		// input the sentence
		// use a for loop to count the number of occurrences of lower-case 'a'
		// in the sentence.
		// output the resulting count of letter 'a' using printf
		// output the number of letters in the String.
		// output your name using printf
		
		// Tip(s):
		
		// class String has a .length() method that lets you know how many times
		// you need to loop.

		// Strings are a sequence of letters indexed from zero to (length - 1)
		
		// class String has a method .charAt(index) that returns the char
		// located at that index
		
		// an if statement can check if the extractedCharacter == 'a'
		// and add 1 to the letterCount if this is true.
		
		// a for loop can start at index 0, and increment up to the length
		// of the String to check each letter one at a time using charAt(index)
		// of class String.
		sentence = user.inputString("Please enter a sentence.\n");
		for (int i = 0; i < sentence.length(); i++) {
			extractedCharacter = sentence.charAt(i);
			if (extractedCharacter == 'a')
				letterCount++;
		}
		System.out.printf("The number of occurences of the letter a is: %d.%nThe length of the sentence is: %d characters.%nJaddua Jones", letterCount, sentence.length());
	}

}
