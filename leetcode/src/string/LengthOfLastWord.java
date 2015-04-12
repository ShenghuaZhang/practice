package string;
/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Given a string s consists of alphabets and empty space characters ' '
 * return the length of last word in the string.
 * 
 * For example, 
 * Given s = "b    Waorld    ",
 * return 6.
 * 
 * @author yili3
 *
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int cnt = 0, previous = cnt;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (cnt != 0)
					previous = cnt;
				cnt = 0;
			} else
				cnt++;
		}

		return cnt == 0 ? previous : cnt;
	}
}
