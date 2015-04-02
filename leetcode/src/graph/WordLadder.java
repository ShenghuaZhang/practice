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
	public int ladderLength(String start, String end, Set<String> dict){
		if(start==null || end==null || start.length()==0 || end.length()==0)
			return 0;
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		int level = 1, lastNum = 1, curNum = 0;
		
		queue.offer(start); //same with queue.add(start);
		visited.add(start);
		while(!queue.isEmpty()){
			String cur = queue.poll();
			lastNum--;
			for(int i=0; i<cur.length(); i++){
				char[] charCur = cur.toCharArray();
				for(char c ='a'; c<= 'z'; c++){
					charCur[i] = c;
					String temp = new String(charCur);
					if(temp.equals(end))	return level+1;
					if(dict.contains(temp) && !visited.contains(temp)){
						curNum++;
						queue.add(temp);
						visited.add(temp);
					}
				}
			}
			if(lastNum==0){
				lastNum = curNum;
				curNum = 0;
				level++;
			}
		}
		return 0;
	}
	
	@SuppressWarnings("unused")
	private boolean oneDiff(String first, String second){
		boolean rs = false;
		for(int i=0; i<first.length(); i++){
			if(first.charAt(i)==second.charAt(i)){
				if(rs = true)	return false;
				else rs = true;
			}
		}
		return rs;
	}
}
