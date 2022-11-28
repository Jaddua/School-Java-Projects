//Jaddua Jones CST_8116 363 Exercise 03
//Box class
public class Box {
	//declaration of attributes
	private double length;
	private double width;
	private double height;
	private double volume;
	private double surfaceArea;
	//overloaded constructor method for Box class with parameters of length, width and height
	public Box(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	//setter method for volume attribute
	public void setVolume(double volume) {
		this.volume = volume;
	}
	//setter method for surfaceArea attribute
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	//getter method for length attribute
	public double getLength() {
		return this.length;
	}
	//getter method for width attribute
	public double getWidth() {
		return this.width;
	}
	//getter method for height attribute
	public double getHeight() {
		return this.height;
	}
	//getter method for volume attribute
	public double getVolume() {
		return this.volume;
	}
	//getter method for surfaceArea attribute
	public double getSurfaceArea() {
		return this.surfaceArea;
	}
	//worker method for calculating the volume of the box given the length, width and height
	public double calcVolume(double length, double width, double height) {
		return length * width * height;
	}
	//worker method for calculating the surface area of the box given the length, width and height
	public double calcSurfaceArea(double length, double width, double height) {
		return 2 * (length * width + length * height + width * height);
	}
}
