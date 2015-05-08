package dynamicProgramming;

import java.util.List;

/**
 * 120
 * https://leetcode.com/problems/triangle/
 * 
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * @author yili3
 *
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0)    return 0;
        
        int[] sum = new int[triangle.size()];
        sum[0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++){
            for(int j=triangle.get(i).size()-1; j>=0;j--){
                if(j==0) sum[j] += triangle.get(i).get(j); 
                else if(j==triangle.get(i).size()-1) sum[j] = sum[j-1] + triangle.get(i).get(j);
                else sum[j] = Math.min(sum[j], sum[j-1])+triangle.get(i).get(j);
            }
        }
        
        int min=sum[0];
        for(int i=1; i<sum.length; i++) min=Math.min(sum[i], min);

        return min;
    }
}
