import java.util.Scanner;
//Staff class
public class Staff {
	//declaring variables and data types
	private double weatherLength;
	private int numPacks;
	private double weathStripPackLength;
	private boolean negZeroFlag;
	private Scanner input = new Scanner(System.in);
	private Door door = new Door();
	//constructor
	public Staff() {
	}
	//getter method for the length of weatherstripping needed
	public double getWeatherLength() {
		return this.weatherLength;
	}
	//getter method for the number of packs required
	public int getNumPacks() {
		return this.numPacks;
	}
	//setter method for the length of weather stripping needed
	public void setWeatherLength(double weatherLength) {
		this.weatherLength = weatherLength;
	}
	//setter method for the length of a weather stripping package
	public void setWeathStripPackLength(double weathStripPackLength) {
	this.weathStripPackLength = weathStripPackLength;
	}
	//worker method for calculating the length of weatherstripping needed
	public void calcWeatherLength() {
		negZeroFlag = true;
		//while loop and if statements to make sure the user only enters values greater than zero
		while(negZeroFlag) {
		System.out.println("What is the height of your door in cm?");
		door.setHeight(input.nextDouble());
		System.out.println("What is the width of your door in cm?");
		door.setWidth(input.nextDouble());
		//checking to see if inputs are strictly positive
		if (door.getHeight() <= 0 || door.getWidth() <= 0) {
			System.out.println("Please only enter positive values. Not negative or zero. Thank you.");
		}
		else {
		setWeatherLength(door.getHeight() * 2.0 + door.getWidth());
		negZeroFlag = false;
		}
		}
		}
	//worker method for calculating the number of packs needed
	public void calcNumPacks() {
		//while loop and if statements to make sure the user only enters values greater than zero
		negZeroFlag = true;
		System.out.println("What is the length of a weather stripping package in cm?");
		while (negZeroFlag) {
		setWeathStripPackLength(input.nextDouble());
		//checking to see if input is strictly positive
		if (weathStripPackLength <= 0) {
			System.out.println("Please only enter positive values. Not negative or zero. Thank you.");
		}
		else {
		numPacks = (int) Math.ceil(weatherLength / weathStripPackLength);
		negZeroFlag = false;
		}
		}
	}
}
