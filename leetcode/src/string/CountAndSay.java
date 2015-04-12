package string;
/**
 * https://leetcode.com/problems/count-and-say/
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author yili3
 *
 */
public class CountAndSay {
	public String countSay(int n){
		String ret = "1";
        
        if (n < 1) return "";
        if (n == 1) return ret;
        while (n > 1){
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < ret.length(); j++){
                if (ret.charAt(j) == ret.charAt(j-1)){
                    count ++;
                }else{
                    temp.append(count);
                    temp.append(ret.charAt(j-1));
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(ret.charAt(ret.length()-1));
            ret = temp.toString();
            n--;
        }
        return ret;
	}
}
