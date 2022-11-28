/*
 * Author: Jaddua Jones
 * Professor: Siju Phillip
 * Date: 2021 December 8
 * Description: Lab Exam 2 Java Code
 */
import java.util.Scanner;
/* This class contains the main method to run the program. */
public class JadduaJonesLabExam2363 {

	public static void main(String[] args) {
		// Declaring variables
		Scanner input = new Scanner(System.in);
		int EDIT_MECHANICAL_PENCIL = 1;
		int PRINT_MECHANICAL_PENCIL = 2;
		int EXIT_MECHANICAL_PENCIL = 3;
		int menuSelect = 0;
		double length = 6.0;
		double width = 0.5;
		MechanicalPencil pencil = new MechanicalPencil();
		//Setting default dimensions for the pencil object
		pencil.setLength(length);
		pencil.setWidth(width);
		System.out.print("Default pencil dimensions are 6 cm in length and 0.5 mm in width.\n");
		//loop for menu selection
		while (menuSelect != EXIT_MECHANICAL_PENCIL) {
			System.out.print("Please select an option from the menu.\n"
					+ "1 to edit mechanical pencil\n"
					+ "2 to print estimated number of pages\n"
					+ "3 to exit the program\n");
			menuSelect = input.nextInt();
			//checking if the option selection is for editing the pencil
			if (menuSelect == EDIT_MECHANICAL_PENCIL) {
				System.out.print("Editing mechanical pencil.\n"
						+ "Please enter the length of the pencil in cm.\n");
				length = input.nextDouble();
				System.out.print("Please enter the width of the pencil in mm.\n");
				width = input.nextDouble();
				System.out.print("Thank you.\n");
				pencil.setLength(length);
				pencil.setWidth(width);
			}
			//checking if the option selection is for displaying number of pages
			else if (menuSelect == PRINT_MECHANICAL_PENCIL) {
				System.out.print("Displaying the estimated number of pages this mechanical pencil can write.\n");
				System.out.printf("The estimated number of pages this pencil can write is: %.2f%n", pencil.estimatePages());
				System.out.print("Thank you.\n");
			}
			//checking if any other value was entered other than 3 since 3 would end the loop
			else if (menuSelect != EXIT_MECHANICAL_PENCIL){
				System.out.print("Invalid selection. Please try again.\n");
			}

		}
		System.out.print("Exiting program. Thank you.");
	}

}
