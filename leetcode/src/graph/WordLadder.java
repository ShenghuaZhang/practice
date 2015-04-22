package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Given two words (start and end), and a dictionary,
 * find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit", end = "cog"
 * dictionary = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lower-case alphabetic characters.
 * 
 * @author yili3
 *
 */
public class WordLadder {
	public static int ladderLength(String start, String end,
			Set<String> dict) {
		if (start == null || end == null || start.length() == 0
				|| end.length() == 0)
			return 0;
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		int level = 1, curNum = 0, lastNum = 1;
		queue.offer(start);
		set.add(start);
		while (!queue.isEmpty()) {
			String current = queue.poll();
			lastNum--;
			for (int i = 0; i < current.length(); i++) {
				char[] charCur = current.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					charCur[i] = c;
					/*
					 * TODO: caution to using toString()
					 * #ArrayCopyDemo
					 * it is actually return the reference address like: [C@4dcbadb4
					 * public String toString() {
					 * 		return getClass().getName() + "@" + Integer.toHexString(hashCode());
					 * }
					 * 
					 * So it is different with toCharArray() which return a char array:
					 * public char[] toCharArray() {
					 * 		// Cannot use Arrays.copyOf because of class initialization order issues
					 * 		char result[] = new char[value.length];
					 * 		System.arraycopy(value, 0, result, 0, value.length);
					 * 		return result;
					 * }
					 */
					String temp = new String(charCur);
					if (temp.equals(end))
						return level + 1;
					if (dict.contains(temp) && !set.contains(temp)) {
						set.add(temp);
						queue.offer(temp);
						curNum++;
					}
				}
			}
			if (lastNum == 0) {
				lastNum = curNum;
				curNum = 0;
				level++;
			}
		}

		return 0;
	}
	
	public static void main(String[] args){
		String start = "hot", end = "dog";
		Set<String> dict = new HashSet<String>(){
			private static final long serialVersionUID = -4240235025178617424L;
			{
				add("hot");
				add("dog");
				add("dot");
			}
		};
		System.out.println(ladderLength(start, end, dict));
	}
}
