package Math;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * 149
 * https://leetcode.com/problems/max-points-on-a-line/
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @author jiakangze
 *
 * #Line #Point
 *
 */
public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point [] points = new Point[2];
		points[0] = new Point(0,0); 
//		points[1] = new Point(1,1); 
		points[1] = new Point(2,2); 
//		points[3] = new Point(4,4); 
//		points[4] = new Point(5,5); 
//		points[5] = new Point(1,2); 
//		points[6] = new Point(2,3); 
//		points[7] = new Point(0,1); 
//		points[8] = new Point(1,-1); 
//		points[9] = new Point(5,9); 
		//there may be some same points in points.[[0,0],[1,1],[0,0]] myoutput is 2, expected is 3.
		System.out.println(maxPoints(points));
	}

    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) { //null and zero is different, so we should consider both situation.
            return 0;
        }
        int max = 1;//if there is only one point, so not 0
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length - 1; i++) {
        	int samePoint = 0;
        	int localMax = 1;//if there are two same points, so not 0
        	for (int j = i+1; j < points.length; j++) {
        		if (points[i].x == points[j].x && points[i].y == points[j].y) {
        			samePoint++;
        			continue;
        		}
        		double slope = 0.0;
        		if (points[i].x == points[j].x) {
        			slope = Double.MAX_VALUE;
        		} else if (points[i].y == points[j].y) {
        			slope = 0.0;
        		} else {
        			slope = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);//do not forget type convert
        		}
        		if (map.containsKey(slope)) {
        			map.put(slope, map.get(slope)+1);
        		} else {
        			map.put(slope, 2);
        		}
        		localMax = Math.max(localMax, map.get(slope));
        	}
        	localMax += samePoint;
        	map.clear();
        	max = Math.max(localMax, max);
        }
        return max;
    }
    
   
}
