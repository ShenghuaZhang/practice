package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * @author yili3
 *
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s){
		List<String> list = new ArrayList<>();
		if(s==null || s.length()<4 || s.length()>12)	return list;
		helper(s, 0, 1, "", list);
		return list;
	}
	private void helper(String s, int index, int segment, String item, List<String> list){
		if(index>=s.length())	return;
		if(segment==4){
			String str = s.substring(index);
			if(isValid(str))	list.add(item+"."+str);
			return;
		}
		for(int i=1; i<4&&(i+index<=s.length()); i++){
			String str = s.substring(index, index+i);
			if(isValid(str)){
				if(segment==1)	helper(s, index+i, segment+1, str, list);
				else	helper(s, index+i, segment+1, item+"."+str, list);
			}
		}
	}
	private boolean isValid(String str){
		if(str==null || (str.length()>1&&str.charAt(0)=='0'))	return false;
		
		int temp = Integer.parseInt(str);
		return	(temp<256&&temp>=0);
	}
}
