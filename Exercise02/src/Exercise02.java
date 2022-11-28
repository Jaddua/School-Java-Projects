//Jaddua Jones
//Import Math class for use in surface area calculation.
import java.lang.Math;
//Import Scanner class to obtain input from the user.
import java.util.Scanner;
//Exercise02 is the class. This is where all of the program will be located for this assignment.
public class Exercise02 {
//This is the main method. This is the method where all of the program will be written for this assignment.
	public static void main(String[] args) {
		//Creating a scanner to obtain user input.
		Scanner input = new Scanner(System.in);
		//Declaring variables and assigning a value to inputFlag at the same as declaration and assigning values to
		//height and diameter because an error was being thrown that height and diameter may not have been initialized. 
		double height = 0;
		//Radius of a circle is half the diameter so for the radius in the formula for surface area diameter/2 will be used.
		double diameter = 0; 
		int surfaceArea;
		//flag variable for if the while loop can be exited. Will be set to true and if only positive inputs are entered then will be set to false.
		boolean inputFlag = true;
		//While statement will continue to loop while argument is true. inputFlag variable is a boolean and set to true so the while loop
		//will continue until inputFlag is set to false.
		while (inputFlag) {
		System.out.println("Please enter the height of the silo in metres.");
		height = input.nextDouble();
		System.out.println("Thank you. Now please enter the diameter of the silo in metres.");
		diameter = input.nextDouble();
			// Checking if either of the inputs are negative or zero.
			if (height <= 0 || diameter <= 0) {
			//The code in this if statement is being executed if the argument of the if statement is true, namely in this case, if either the height
			//or the diameter is less than or equal to zero.
				//Telling user to only enter values greater than zero and to try again.
				System.out.println("Please only enter values greater than zero. Please try again.");
				//The inputFlag variable is still set to true so there is no need to change it. Since the user did not enter values
				//greater than zero for this if statement to be executed, the while loop will need to continue so the user can input
				//values again
			}
			//If the above if statement argument is false then it means the height and diameter must both have values
			//greater than zero. Since there is no need to check if they are greater than zero (it is only possible for them 
			//to both be greater than zero if the if statement argument is false) then an else statement can be used.
			else {
				//Will be setting the inputFlag variable to false so that the while loop will end and the current values of height and diameter
				//will be taken as user input that has been checked and ensured to be greater than zero.
				inputFlag = false;
			}
		}
		//Calculating the surface area, rounding it up to the next whole number and storing it in surfaceArea. 
		//Will be casting surfaceArea variable to an integer because I do not like the .0 when printing a double with an integer value.
		surfaceArea = (int) Math.ceil((Math.PI * Math.pow((diameter/2),2)) + (2 * Math.PI * (diameter/2) * height));
		//Outputting the final answer with some text to tell the user that the value they are looking at is the surface area of the silo.
		//obtaining the string value of the surfaceArea variable with the String.valueOf() method so it can be concatenated with the 
		//other text and outputted with System.out.println.
		System.out.println("The surface area of the silo is: " + String.valueOf(surfaceArea) + " metres squared.");
		//Outputting Program by Jaddua Jones.
		System.out.println("Program by Jaddua Jones");
	}

}
