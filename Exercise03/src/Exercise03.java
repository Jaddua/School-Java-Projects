//Jaddua Jones CST_8116 363 Exercise 03
//import Scanner to use for input
import java.util.Scanner;
//Exercise03 class
public class Exercise03 {
	//declaration of attributes, static so that I can use in the main method
	private Scanner input = new Scanner(System.in);
	private double length;
	private double width;
	private double height;
	private boolean negZeroFlag;
	//main method to run the program
	public static void main(String[] args) {
		//this ex3 object exists so I can access and modify the attributes input, length, width and height 
		//in the main method without making the attributes static
		Exercise03 ex3 = new Exercise03();
		//a boolean variable that will be true by default , if all input are greater than zero then the variable will be set to false
		ex3.negZeroFlag = true;
		//this while loop will loop if the inputs are not greater than zero, the program will check if all of the inputs are greater than zero
		//and if they are then the boolean variable will be set to false and the while loop will end allowing the program to continue. 
		//If they are not all greater than zero then using an else statement it will ask the user to try again with only inputs greater than zero.
		//This will ensure that all inputs are greater than zero
		while(ex3.negZeroFlag) {
		System.out.println("Enter the length of the box in cm");
		ex3.length = ex3.input.nextDouble();
		System.out.println("Enter the width of the box in cm");
		ex3.width = ex3.input.nextDouble();
		System.out.println("Enter the height of the box in cm");
		ex3.height = ex3.input.nextDouble();
		if (ex3.length > 0 && ex3.width > 0 && ex3.height > 0) {
			ex3.negZeroFlag = false;
		}
		else {
			System.out.println("Please only enter values greater than zero. Try again.");
		}
		}
		//creating box object
		Box box = new Box(ex3.length, ex3.width, ex3.height);
		//calculating volume and then setting the volume attribute of the box object to this result
		box.setVolume(box.calcVolume(box.getLength(), box.getWidth(), box.getHeight()));
		//calculating surface area and then setting the surfaceArea attribute of the box object to this result
		box.setSurfaceArea(box.calcSurfaceArea(box.getLength(), box.getWidth(), box.getHeight()));
		//ouputting the volume and surface area of the program
		System.out.println("The volume of the box is " + String.valueOf(box.getVolume()) + " cm cubed.");
		System.out.println("The surface area of the box is " + String.valueOf(box.getSurfaceArea()) + " cm squared.");
		//ouput that the program is written by me, Jaddua Jones
		System.out.println("Program by Jaddua Jones");
	}

}
