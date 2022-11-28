//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*Jaddua Jones CST_8116 363 Assignment 02*/
//ToDo: Supervisor wants programmer comments (use /* */ comment)
/*class DrinkMachine for calculating attributes of the drink machine like volume of cups and for giving
 * the measured volume for testing if within tolerance */
public class DrinkMachine {
	public static final String SMALL = "small";
	public static final String MEDIUM = "medium";
	public static final String LARGE = "large";
	public static final double SMALL_VOLUME = 250.0;
	public static final double MEDIUM_VOLUME = 400.0;
	public static final double LARGE_VOLUME = 500.0;
	// ToDo: declare an EPSILON constant with value of 10.0
	//       i.e. is measured volume within 10ml of expected volume?
	public static final double EPSILON = 10.0;
	private double volume; // (ml)
	private String size; // "small", "medium", "large"
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*Null constructor for DrinkMachine class*/
	public DrinkMachine() {
		this(DrinkMachine.MEDIUM_VOLUME, DrinkMachine.MEDIUM);
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*Overloaded constructor for DrinkMachine class*/
	public DrinkMachine(double volume, String size) {
		this.volume = volume;
		this.size = size;
	}

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*getter method for volume*/
	public double getVolume() {
		return volume;
	}

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*setter method for volume*/
	public void setVolume(double volume) {
		this.volume = volume;
	}

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*getter method for size*/
	public String getSize() {
		return size;
	}

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*setter method for size*/
	public void setSize(String size) {
		this.size = size;
	}

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	/*method to check if the measured volume is within an allowable tolerance*/
	public String verifySize() {
		String report = "";
		//ToDo: Use the size to determine the volume you are testing against.
		//      then use EPSILON to determine if the expected volume, and
		//      actual volume are "close enough", then return a string
		//      as a report. E.g. 
//E.g. 
//"size is small, volume is 255.0 ml, difference is 5.0 ml, within tolerance of 10.0 ml "
//E.g. 
//"size is medium, volume is 389.0 ml, difference is 11.0 ml, outside of tolerance of 10.0 ml"
//E.g.
//"size is tuna, volume is -45, difference is 0.0 ml, invalid size or volume input"
		//      You can use any decision structure you want.
		//      You must use String.format(String, , , ) to generate the report.
		//      Tip: See drinkSizeMenu() below for an example of String.format
		double difference = 0.0;
		boolean check = true;
		if (getVolume() < 0) {
			check = false;
			report = "Size is %s, volume is %.1f ml, difference is %.1f ml, invalid size or volume input.";
		}
		else {
			switch (getSize()) {
				case SMALL:
					difference = Math.abs(getVolume() - SMALL_VOLUME);
					break;
				case MEDIUM:
					difference = Math.abs(getVolume() - MEDIUM_VOLUME);
					break;
				case LARGE:
					difference = Math.abs(getVolume() - LARGE_VOLUME);
					break;
				default:
					check = false;
					report = "Size is %s, volume is %.1f ml, difference is %.1f ml, invalid size or volume input.";
			}
		}
		if (check) {
			if (Math.abs(difference) <= EPSILON)
				report = "Size is %s, volume is %.1f ml, difference is %.1f ml, within tolerance of 10.0 ml";
			else
				report = "Size is %s, volume is %.1f ml, difference is %.1f ml, outside tolerance of 10.0 ml";
		}
		report = String.format(report, getSize(), getVolume(), difference);
		return report;
	}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	//ToDo: verify the menu is correct and fix any problems.
	/*method to print the drink size menu*/
	public String drinkSizeMenu() {
		String report = String.format(
				"Drink sizes:%n%s is %.1f (ml)%n%s is %.1f (ml)%n%s is %.1f (ml)",
				DrinkMachine.SMALL, DrinkMachine.SMALL_VOLUME,
				DrinkMachine.MEDIUM, DrinkMachine.MEDIUM_VOLUME,
				DrinkMachine.LARGE, DrinkMachine.LARGE_VOLUME
				);
		return report;
	}

}
