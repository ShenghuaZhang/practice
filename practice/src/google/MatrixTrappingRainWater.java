package google;
/**
 * Give a matrix n*m non-negative integers representing an 
 * elevation map where the breadth and width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * 
 * @author carllee1991
 * 
 * #TrappingRainWater
 *
 */
public class MatrixTrappingRainWater {
	public int trap3D(int[][] height){
		if(height==null || height.length==0)	return 0;
		int[][] container = new int[height.length][height[0].length];
		int rowL = height.length, columnL = height[0].length;
		int res = 0;
		
		for(int row=1; row<rowL-1; row++){
			int max = height[row][0];
			for(int column=1; column<columnL-1; column++){
				container[row][column] = max;
				max = Math.max(max, height[row][column]);
			}
			max = height[row][columnL-1];
			for(int column=columnL-2; column>0; column--){
				container[row][column] = Math.min(max, container[row][column]);
				max = Math.max(max, height[row][column]);
			}
		}
		
		for(int column=1; column<columnL-1; column++){
			int max = height[0][column];
			for(int row=1; row<rowL-1; row++){
				container[row][column] = Math.min(container[row][column], max);
				max = Math.max(max, height[row][column]);
			}
			max = height[rowL-1][column];
			for(int row=rowL-2; row>0; row--){
				container[row][column] = Math.min(container[row][column], max);
				max = Math.max(max, height[row][column]);
				if(container[row][column]-height[row][column]>0)
					res += container[row][column]-height[row][column];
			}
		}
		
		return res;
	}
}
