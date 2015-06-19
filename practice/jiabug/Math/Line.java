package Math;

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
        return ((double) y) * epsilon; 
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
