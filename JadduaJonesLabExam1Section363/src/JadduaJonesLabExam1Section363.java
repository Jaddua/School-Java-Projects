//Jaddua Jones CST_8116 363
public class JadduaJonesLabExam1Section363 {

	public static void main(String[] args) {
		PencilLead testLead = new PencilLead();
		//Set the length variable of testLead
		testLead.setLength(6);
		//Set the width variable of testLead
		testLead.setWidth(0.5);
		//Display the length and width of the testLead object
		System.out.println(String.valueOf(testLead.getLength()) + " cm long and " + String.valueOf(testLead.getWidth()) + " mm wide.");
		System.out.println("The length in cm is " +  String.valueOf(testLead.getLength()) + ".");
		System.out.println("The width in mm is " +  String.valueOf(testLead.getWidth()) + ".");
		//Set the numPages variable to the value of the calcNumPages method when using the length and width variables of the testLead object
		testLead.setNumPages(testLead.calcNumPages(testLead.getLength(), testLead.getWidth()));
		//Display the value of the numPages variable of the testLead object
		System.out.println("The estimated number of pages is " + String.valueOf(testLead.getNumPages()) + ".");
		System.out.println("Program by Jaddua Jones.");
	}

}
