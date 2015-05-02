package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a digit string, return all possible letter combinations that
 * the number could represent.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author yili3
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if(digits==null || digits.length()==0)	return list;
        
		Map<Character, String> map = new HashMap<Character, String>(){
			private static final long serialVersionUID = 1L;
			{
                put('1', ""); put('2', "abc"); put('3', "def");
                put('4', "ghi"); put('5', "jkl"); put('6', "mno");
                put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");
                put('0', " "); put('*', "+");
            }
        };

    	StringBuilder sb = new StringBuilder();
        helper(digits, map, sb, 0, list);
        
        return list;
    }
	private void helper(String digits, Map<Character, String> map, StringBuilder sb, int index, List<String> list){
		if(index==digits.length()){
			list.add(sb.toString());
			return;
		}
		String rep = map.get(digits.charAt(index));
		
		for(int i=0; i<rep.length(); i++){
			sb.append(rep.charAt(i));
			helper(digits, map, sb, index+1, list);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
