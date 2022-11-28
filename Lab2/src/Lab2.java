import java.util.Scanner;
import java.lang.Math;
public class Lab2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the height of the silo in metres.");
		double height = input.nextDouble();
		input.nextLine();
		System.out.println("Enter the diameter of the silo in metres.");
		double diameter = input.nextDouble();
		input.nextLine();
		int surfaceArea = (int) Math.ceil((Math.PI * Math.pow((diameter/2),2)) + (2 * Math.PI * (diameter/2) * height));
		if(surfaceArea == 1) {
		System.out.println("The surface area of the silo is " + surfaceArea + " square metre.");
		}
		else {
			System.out.println("The surface area of the silo is " + surfaceArea + " square metres.");
		}
		System.out.println("Program by Jaddua Jones");
	
	}

}
