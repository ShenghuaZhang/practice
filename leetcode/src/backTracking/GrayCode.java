package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * 
 * @author carllee1991
 *
 */
public class GrayCode {
	public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if(n<=0)    return list;
        list.add(0);    list.add(1);
        for(int i=2; i<=n; i++){
        	int size = list.size();
            for(int j=0; j<size*2; j+=4){
            	list.add(j+1, list.get(j)+2^(i-1));
            	list.add(j+2, list.get(j+2)+2^(i-1));
            }
        }
        
        return list;
    }
	public static void main(String[] args){
		System.out.println(grayCode(3));
	}
}
