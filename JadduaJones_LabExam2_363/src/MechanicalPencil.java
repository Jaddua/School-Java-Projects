/*
 * Author: Stanley Pieda
 * Professor: Lab Professor
 * Date: Nov  23, 2021
 * Description: Lab Exam 2 Starter Code
 */

/* This class abstracts a mechanical pencil */
public class MechanicalPencil {
	private double length;
	private double width;
	
	/* Default, no parameters constructor */
	public MechanicalPencil() {
		
	}

	/* Accessor for length */
	public double getLength() {
		return length;
	}

	/* Mutator for length */
	public void setLength(double length) {
		this.length = length;
	}

	/* Accessor for width */
	public double getWidth() {
		return width;
	}

	/* Mutator for width */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/* Work method to estimate pages a single lead in a mecahnical pencil will
	 * write 
	 */
	public double estimatePages() {
		return length * width * 10;
	}
}
