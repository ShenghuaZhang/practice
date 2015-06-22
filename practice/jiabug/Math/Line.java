package Math;

public class Line {
	public static double epsilon = 0.000001;//the more less, the more accurate.
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
    
    //when we compare 0.00000001 with 0, they may equal with each other. that is when the two numbers are very close, they may equal 
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
    //we compare two double numbers using the gap epsilon. the more less of epsilon, the more accurate.
    //we also can directly compare two double numbers using == , because the two numbers both come from the specific formula, if one can not be represented by 
    //binary accurately, neither is the another one. but if we compare a formula with a specific number, there may be problem..http://stackoverflow.com/questions/8081827/how-to-compare-two-double-values-in-java
    //when we hash the key, we need do floor to nearest first. because we use epsilon gap comparing.
    //what's more, when we count the equivalent line, we need add and minus epsilon. consider 1.999 and 2.000, they are equal, but they will be hashed to two keys.

}
