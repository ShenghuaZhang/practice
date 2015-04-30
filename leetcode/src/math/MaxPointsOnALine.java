package math;
/**
 * 149
 * https://leetcode.com/problems/max-points-on-a-line/
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if(points==null || points.length==0)	return 0;
        
        int max = 1;
        double ratio = 0.0;
        Map<Double, Integer> map = new HashMap<>();
        for(int i=0; i<points.length-1; i++){
        	int samePoints =0, localMax = 1;
            for(int j=i+1; j<points.length; j++){
            	if(points[i].x==points[j].x && points[i].y==points[j].y){
            		samePoints++;
            		continue;
            	}
            	else if(points[i].x==points[j].x) ratio = Double.MAX_EXPONENT;
            	else if(points[i].y==points[j].y) ratio = 0.0;
            	else ratio = (double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);
            	
                if(map.containsKey(ratio))  map.put(ratio, map.get(ratio)+1);
                else map.put(ratio, 2);
                localMax = Math.max(localMax, map.get(ratio));
            }
            localMax+=samePoints;
            map.clear();
            max= Math.max(max, localMax);
        }
        return max;
    }
}
