package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * @author carllee1991
 *
 */
public class GrayCode {
	List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if(n<0)		return list;
        list.add(0);
        if(n==0)	return list;
        list.add(1);
        for(int i=2; i<=n; i++){
        	int size = list.size();
            for(int j=0; j<size*2; j+=4){
            	list.add(j+1, list.get(j)+size);
            	list.add(j+2, list.get(j+2)+size);;
            }
        }
        
        return list;
    }
	
	List<Integer> grayCodeAC(int n){
		List<Integer> list = new ArrayList<>();
        if(n<0)		return list;
        list.add(0);
        if(n==0)	return list;
        list.add(1);
        for(int i=2; i<=n; i++){
        	int size = list.size();
            for(int j=size-1; j>=0; j--){
            	list.add(list.get(j)+(1<<(i-1)));
            }
        }
        
        return list;
	}
	
	// append reverse of order n gray code to prefix string, and print
    public static void yarg(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1);
        }
    }  
    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
    }  
	// 000 001 011 010 110 111 101 100
	public static void main(String[] args){
		GrayCode code = new GrayCode();
		System.out.println(code.grayCode(3));
		System.out.println(code.grayCodeAC(3));
		gray("", 3);
	}
}
