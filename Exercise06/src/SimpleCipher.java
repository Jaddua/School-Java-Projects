/* Exercise 06 (21F) 
 * Author: Stanley Pieda
 * Modified By: Jaddua Jones
 * Lab Professor: Siju Phillip
 * November 26 2021
 */
/*
 * This is the SimpleCipher class that has methods to encode and decode text, as well reverse a char array.
 */
public class SimpleCipher {
	
    /*
     * This method will encode the given text.
     */
	public String encode(String text) {
		String result = "";
		// ToDo
		// convert text into char array
		// reverse the array using provided method (see below)
		// loop over array adding 2 to each element
		// convert the char array back to a String named result
		// return the resulting String.
		char[] messageArray = text.toCharArray();
		messageArray = reverse(messageArray);
		for (int i = 0; i < messageArray.length; i++) {
			messageArray[i] = (char) (messageArray[i] + 2);
		}
		result = new String(messageArray);
		System.out.println(result);
		return result;
	}
	
    /*
     * This method will decode the given text.
     */
	public String decode(String text) {
		String result = "";
		// ToDo
		// convert text into char array
		// reverse the array using provided method (see below)
		// loop over array subtracting 2 from each element
		// convert the char array back to a String named result
		// return the resulting String.
		char[] messageArray = text.toCharArray();
		messageArray = reverse(messageArray);
		for (int i = 0; i < messageArray.length; i++) {
			messageArray[i] = (char) (messageArray[i] - 2);
		}
		result = new String(messageArray);
		return result;
	}
	
	/*
	 * This method will reverse a char array.
	 * Note: This method is already completed.
	 */
	private char[] reverse(char[] original) {
		int length = original.length;
		char[] reversed = new char[length];
		int writeIndex = 0;
		for(int readIndex = length - 1; readIndex >= 0; readIndex--) {
			reversed[writeIndex] = original[readIndex];
			writeIndex++;
		}
		// the readIndex above starts at the last index, and stops at index zero
		// the writeIndex starts at zero, and stops at the last index.
		return reversed;
	}
}
