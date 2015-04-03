package hash;

public class Dictionary {
	// TODO: How to use Hash table implement a dictionary?
	final static int NUMBERWORDS = 50000;
	final static int SIZE = (int) (NUMBERWORDS * 2);

	public static int hashFunc(String s) {
		int location = 0;

		for (int j = 0; j < s.length(); j++) {
			/*
			 * multiplication can be effected using the shift operator,
			 * which even faster than the modulo operator
			 */
			location = location << 5 + (s.charAt(j) - 96);
			/*
			 * to avoid overflow, the modulo operator can be applied at each
			 * step in the process, if the polynomial is expressed using Horner's
			 * method.
			 */
			location %= SIZE;
		}

		return location;
	}
	
	public static void main(String[] args){
		String s = "sdlfjalj";
		System.out.println(s.charAt(1)-96);
		System.out.println(hashFunc(s));
	}
}
