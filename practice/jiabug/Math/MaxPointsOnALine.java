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
		Point [] points = new Point[3];
		points[0] = new Point(0,0); 
		points[1] = new Point(1,1); 
		points[2] = new Point(0,0); 
		Line l = new Line(points[0], points[2]);
		System.out.println(l.intercept);
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
        HashMap<Double, ArrayList<Line>> total = new HashMap<Double, ArrayList<Line>>();
        int bestCount = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++){
                Line l = new Line(points[i], points[j]);
                insertLine(total, l);
                int count = countNumber(total, l);
                if (count > bestCount) {
                    bestCount = count;
                }
            }
        }
        return (int) ((1 + Math.sqrt(1 + 8 * bestCount)) / 2);
    }
    
    public static int countNumber (ArrayList<Line> line, Line l) {
        if (line == null) {
            return 0;
        }
        int count = 0;
        for (Line t:line) {
            if (l.isEquavelent(t)) {
                count++;
            }
        }
        return count;
    }
    
    public static int countNumber (HashMap<Double, ArrayList<Line>> total, Line l) {
        double key = l.floorToNeareat(l.slope);
        int count = countNumber(total.get(key), l) +countNumber(total.get(key + Line.epsilon), l) + 
                    countNumber(total.get(key - Line.epsilon), l);//2.000001 and 1.9999999 and 2.0000000
        return count;
    }
    
    public static void insertLine(HashMap<Double, ArrayList<Line>> total, Line line) {
        ArrayList<Line> arr = null;
        double key = line.floorToNeareat(line.slope);
        if (!total.containsKey(key)) {
            arr = new ArrayList<Line>();
            total.put(key, arr);
        } else {
            arr = total.get(key);
        }
        arr.add(line);
    }
}
