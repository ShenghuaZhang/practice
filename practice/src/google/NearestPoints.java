package google;

import java.awt.Point;

/**
 * 3
 * https://docs.google.com/file/d/0BwTHFkU-BZ7MaTgxWkZxOFIwV3c/edit
 * get from part of google interview question
 * giving a point, give the angle with X coordinate
 * 
 * @author carllee1991
 *
 */
class PointAndAngle{
	Point point;
	double angle;
	public PointAndAngle(Point p, double a){
		this.point = p;
		this.angle = a;
	}
}
public class NearestPoints {
	public static double getAngle(Point a){
		if(a.x==0 && a.y>0)	return Math.PI/2;
		if(a.y>0)	return Math.atan((double)a.y/a.x);
		if(a.x<0 && a.y==0)	return 3*Math.PI/2;
		else return 2*Math.PI-Math.atan((double)a.y/a.x);
	}
	
	private static double getDistance(Point a, Point b){
		return Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
	}
	
	private static void getMergeSorted(PointAndAngle[] p){
		mergeSort(p, 0, p.length-1);
	}
	private static void mergeSort(PointAndAngle[] p, int left, int right){
		if(left>=right)	return;
		int middle = (left+right)/2;
		mergeSort(p, left, middle);
		mergeSort(p, middle+1, right);
		merge(p, left, right);
	}
	private static void merge(PointAndAngle[] p, int left, int right){
		PointAndAngle[] C = new PointAndAngle[right-left+1];
		int first=left, second = (left+right)/2+1, i=0;
		
		while(first<=(left+right)/2 && second<=right){
			if(p[first].angle<p[second].angle)	C[i++] = p[first++];
			else C[i++] = p[second++];
		}
		while(first<=(left+right)/2)	C[i++] = p[first++];
		while(second<=right)	C[i++] = p[second++];
		
		for(i=0; i<C.length; i++)	p[left+i] = C[i];
	}
	
	private static int binarySearch(PointAndAngle[] insideAngle, double angle){
		int left=0, right=insideAngle.length;
		while(left<=right){
			int middle = (left+right)>>>1;
			if(insideAngle[middle].angle>angle)	right = middle-1;
			else if(insideAngle[middle].angle==angle) return middle;
			else left = middle+1;
		}
		return left;
	}
	
	public static Point[] getNearest(Point[] inside, Point[] outside){
		PointAndAngle[] insideAngle = new PointAndAngle[inside.length];
		PointAndAngle[] outsideAngle = new PointAndAngle[outside.length];
		for(int i=0; i<inside.length; i++)
			insideAngle[i] = new PointAndAngle(inside[i], getAngle(inside[i]));
		for(int i=0; i<outside.length; i++)
			outsideAngle[i] = new PointAndAngle(outside[i], getAngle(outside[i]));
		getMergeSorted(insideAngle);
		
		Point[] ret = new Point[2];
		double min = 0;
		for(int i=0; i<outside.length; i++){
			int left = binarySearch(insideAngle, outsideAngle[i].angle);
			double distance = getDistance(insideAngle[left].point, outsideAngle[i].point);
			if (min==0 || min>distance){
				min = distance;
				ret[0] = insideAngle[left].point;
				ret[1] = outsideAngle[i].point;
			}
		}
		
		System.out.println("distans: "+min+"\nPoint: "+ret[0].x+", "+ret[0].y+" and "+ret[1].x+", "+ret[1].y);
		
		return ret;
	}

	public static void main(String[] args){
		Point[] inside = new Point[4], outside = new Point[5];
		inside[0] = new Point(1, 1);
		inside[1] = new Point(-1, 1);
		inside[2] = new Point(-1, -1);
		inside[3] = new Point(1, -1);
		outside[0] = new Point(10, 5);
		outside[1] = new Point(-4, 11);
		outside[2] = new Point(-6, -7);
		outside[3] = new Point(12, -2);
		outside[4] = new Point(11, 11);
		
		getNearest(inside, outside);
	}
}
