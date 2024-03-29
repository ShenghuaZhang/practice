package string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 * 
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * @author yili3
 *
 */

public class TextJustification {
	public static List<String> fullJustify(String[] words, int L) {
		ArrayList<String> res = new ArrayList<String>();
		if (words == null || words.length == 0)
			return res;
		int count = 0;
		int last = 0;
		for (int i = 0; i < words.length; i++) {
			if (count + words[i].length() + (i - last) > L) {
				int spaceNum = 0;
				int extraNum = 0;
				if (i - last - 1 > 0) {
					spaceNum = (L - count) / (i - last - 1);
					extraNum = (L - count) % (i - last - 1);
				}
				StringBuilder str = new StringBuilder();
				for (int j = last; j < i; j++) {
					str.append(words[j]);
					if (j < i - 1) {
						for (int k = 0; k < spaceNum; k++) {
							str.append(" ");
						}
						if (extraNum > 0) {
							str.append(" ");
						}
						extraNum--;
					}
				}
				for (int j = str.length(); j < L; j++) {
					str.append(" ");
				}
				res.add(str.toString());
				count = 0;
				last = i;
			}
			count += words[i].length();
		}
		StringBuilder str = new StringBuilder();
		for (int i = last; i < words.length; i++) {
			str.append(words[i]);
			if (str.length() < L)
				str.append(" ");
		}
		for (int i = str.length(); i < L; i++) {
			str.append(" ");
		}
		res.add(str.toString());
		return res;
	}

	public static void main(String[] args) {
		String[] words = new String[] { "This", "is", "an", "example", "of",
				"text", "justification." };
		System.out.print(fullJustify(words, 16));
	}
}
