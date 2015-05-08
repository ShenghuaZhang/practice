package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 60
 * https://leetcode.com/problems/permutation-sequence/
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"	"132"	"213"	"231"	"312"	"321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author yili3
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k){
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=n; i++) list.add(i);
		StringBuilder sb = new StringBuilder();
		int size = n, fact = factorial(size-1);
        while(sb.length()<size){
            int temp = (k-1)/fact;
            sb.append(list.get(temp));
            list.remove(temp);
            k -= temp*fact;
            n--;
            if(n!=0)	fact /= n;
        }
        return sb.toString();
    }
	private int factorial(int n){
        if(n==0)	return 1;
        int result=1;
        for(int i=1; i<=n; i++)	result*=i;
        return result;
    }
}
