/*
 * comments needed
 */
//Jaddua Jones CST_8116 363 Exercise 04

import java.util.Scanner;

/*
 * comments needed
 */
//Driver class Exercise04 with main method for executing program.
public class Exercise04 {

	/*
	 * comments needed
	 */
	//Main method for executing program.
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.println("Please enter the age as an integer.");
		customer.setAge(keyboard.nextInt());
		double price = customer.ticketPrice();
		if (price < 0) {
			System.out.println("Invalid age entered. Only ages from 0 to 129 are valid.");
		}
		else {
			System.out.printf("The price of the ticket is: $%.2f%n", price);
		}
		System.out.print("Program by Jaddua Jones.");
		//Suggestion: get the inputs, use an if to check the age
		// if the age is invalid, just report an error and stop
		// if the age is valid, set the values into the object and 
		// use the worker method to obtain the ticket price.
		// OR
		// detect if the returned price is less than zero and then
		// report an error message instead of a price.

	}
}
