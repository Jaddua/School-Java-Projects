//Jaddua Jones CST_8116 363
//PencilLead class with public access modifier
public class PencilLead {
//Declaring variables with datatypes with private access modifiers
private double length;
private double width;
private double numPages;
//Constructor method for PencilLead class with public access modifier
public PencilLead() {
	
}
//Setter method for length variable with public access modifier and void datatype
//with parameter length that has double datatype
public void setLength(double length) {
	this.length = length;
}
//Setter method for width variable with public access modifier and void datatype
//with parameter width that has double data type
public void setWidth(double width) {
	this.width = width;
}
//Setter method for numPages variable with public access modifier and void datatype
//with parameter numPages that has double datatype
public void setNumPages(double numPages) {
	this.numPages = numPages;
}
//Getter method for length variable with public access modifier and double datatype
public double getLength() {
	return this.length;
}
//Getter method for width variable with public access modifier and double datatype
public double getWidth() {
	return this.width;
}
//Getter method for numPages variable with public access modifier and double datatype
public double getNumPages() {
	return this.numPages;
}
//Worker method for calculating the estimated number of pages 
//using the length variable and the width variable with public access modifier
//and double datatype with parameter length that has double datatype and
//parameter width that has double datatype
public double calcNumPages(double length, double width) {
	return length * width * 10;
}
}
