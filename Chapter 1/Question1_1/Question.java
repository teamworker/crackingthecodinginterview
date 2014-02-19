package Question1_1;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * 
 * @author Andy
 * @date Feb 16, 2014
 * @time 4:53:34 PM
 */

/*
 * Solution 1 : Our first solution is to create an array of boolean values,
 * where the flag at index i indicates whether character i in the alphabet is
 * contained in the string. If you run across this character a second time, you
 * can immediately return false.
 * The time complexity for this code is 0( n ), where n is the length of the
 * string. The space complexity is 0 ( 1).
 */
public class Question {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	/*
	 *  We can reduce our space usage by
	 * a factor of eight by using a bit vector. We will assume, in the below
	 * code, that the string only uses the lower case letters a through z. This
	 * will allow us to use just a single int.
	 */
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println("Test : "+(2<<9)); 带符号左移
		String[] words = { "abcde", "hello", "apple", "kite", "padle" };
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " "
					+ isUniqueChars2(word));
		}
	}

}
