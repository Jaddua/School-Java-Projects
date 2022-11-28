/*
 * Comment needed
 */
//Jaddua Jones CST_8116 363 Exercise 04
/*
 * Comment needed
 */
//Customer class to represent the customer buying the movie tickets.
public class Customer {
	private int age;
	
	/*
	 * Comment needed
	 */
	//This is a null constructor that will set class level variable age to zero using the overloaded constructor and this(0).
	public Customer() {
		this(0);
	}
	
	/*
	 * Comment needed
	 */
	//This is an overloaded constructed that will set class level variable age to parameter age.
	public Customer(int age) {
		this.age = age;
	}

	/*
	 * Comment needed
	 */
	//getter method for the class level variable age
	public int getAge() {
		return age;
	}

	/*
	 * Comment needed
	 */
	//setter method for class level variable age
	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * Comment needed, document here what a return value of -1 indicates
	 * so that other programmers will know.
	 */
	//A return value of -1 will indicate that an invalid age was entered, i.e., an age that is less than zero or greater than or equal to 130.
	public double ticketPrice() {
		double price = -1.0; // set to -1 in case the age is invalid.
		// if the age is less than zero, or greater than or equal 
		// to 130 return -1.0
		// use nested if statements with ranges to determine the price.
		// return the determined price
		int age = getAge();
		if(age >= 0 && age < 2) {
			price = 0;
		}
		else if(age >= 2 && age <= 18) {
			price = 15;
		}
		else if (age >= 19 && age < 65) {
			price = 20;
		}
		else if (age >= 65 && age < 130){
			price = 12;
		}
		
		return price; 
	}
	
}
