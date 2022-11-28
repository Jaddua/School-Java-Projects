//Assignment01 class
public class Assignment01 {
	//main method
	public static void main(String[] args) {
		Staff staff = new Staff();
		//calling worker methods from staff object
		staff.calcWeatherLength();
		staff.calcNumPacks();
		System.out.println("The total length of weather stripping required is: " + String.valueOf(staff.getWeatherLength()) + " cm.");
		String ans1 = "Based on this length, you will need " + String.valueOf(staff.getNumPacks());
		String ans2 = "";
		//if number of packs is one then don't have plural
		//otherwise have plural
		if (staff.getNumPacks() == 1) {
			ans2 = " pack of weather stripping.";
		}
		else {
			ans2 = " packs of weather stripping.";
		}
		System.out.println(ans1 + ans2);
		System.out.println("Program by Jaddua Jones");
	}
}
