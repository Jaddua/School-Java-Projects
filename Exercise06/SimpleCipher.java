/* File level comment section
 */

/*
 * comment to overview the class
 */
public class SimpleCipher {
	
    /*
     * comments here to overview the method
     */
	public String encode(String text) {
		String result = "";
		// ToDo
		// convert text into char array
		// reverse the array using provided method (see below)
		// loop over array adding 2 to each element
		// convert the char array back to a String named result
		// return the resulting String.
		return result;
	}
	
    /*
     * Comments that overview the method.
     */
	public String decode(String text) {
		String result = "";
		// ToDo
		// convert text into char array
		// reverse the array using provided method (see below)
		// loop over array subtracting 2 from each element
		// convert the char array back to a String named result
		// return the resulting String.
		return result;
	}
	
	/*
	 * Comments that overview the method.
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
