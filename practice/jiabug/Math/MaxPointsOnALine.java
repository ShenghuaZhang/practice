package Math;
/**
 * 
 * 149
 * https://leetcode.com/problems/max-points-on-a-line/
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @author jiakangze
 *
 */
public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        HashMap<Double, ArrayList<Line>> total = new HashMap<Double, ArrayList<Line>>();
        Line bestLine = null;
        int bestCount = 0;
        for (int i = 0; i < points.lengh; i++)
            for (int j = i+1; j < points.length; j++){
                Line l = new Line(points[i], points[j]);
                insetLine(total, l);
                int count = countNumber();
                if (count > bestCount) {
                    bestCount = count;
                }
            }
            return bestCount;
    }
    
    public int countNumber (ArrayList<Line> line, Line l) {
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
    
    public int countNumber (HashMap<Double, ArrayList<Line>> total, Line l) {
        double key = l.floorToNeareat(l.slope);
        int count = countNumber(total.getKey(key), l) +countNumber(total.getKey(key + Line.epsilon), l) + 
                    countNumber(total.getKey(key - Line.epsilon), l);
        return count;
    }
    
    public void insertLine(HashMap<Double, ArrayList<Line>> total, Line line) {
        ArrayList<Line> arr = null;
        double key = line.floorToNeareat(line.slope);
        if (!total.contains(key)) {
            arr = new ArrayList<Line>();
            total.put(key, arr);
        } else {
            arr = total.getKey(key);
        }
        arr.add(line);
    }
}

public class Line {
    public static double epsilon = 0.000001;
    public double slope, intercept;
    private boolean infinite_slope = false;
    
    public Line (Point p1, Point p2) {
        if (p1.x == p2.x) {
            infinite_slope = true;
            intercept = p1.x;
        } else {
            slope = (p1.y - p2.y) / (p1.x - p2.x);
            intercept = p1.y - p1.x * slope;
        }
    }
    
    public double floorToNeareat(double x) {
        int y = (int) (x / epsilon);
        return (double y) * epsilon; 
    }
    
    public boolean isEquavelent(double x1, double x2) {
        return Math.abs(x1 - x2) <= epsilon;
    }
    
    public boolean isEquavelent(Object o) {
        Line l = (Line) o;
        if (isEquavelent(l.slope, slope) && isEquavelent(l.intercept, intercept) && l.infinite_slope == infinite_slope) {
            return true;
        }
        return false;
    }
}