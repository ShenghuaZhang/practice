package Math;

/**
 * 223
 * https://leetcode.com/problems/rectangle-area/
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 * @author kajia
 *
 */


public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area_overlap = 0;
		int width = 0;
		if (E >= C || A >= G || B >= H || F >= D) {
			area_overlap = 0;
		} else {
		
		int hight = helper(B, D, F, H);
		if (E > A) {
			if (G > C) {
				width = C - E;
			} else {
				width = G - E;
			}
		} else {
			if (C < G) {
				width = C - A;
			} else {
				width = G - A;
			}
		}
		area_overlap = width * hight;
		}
		return (C - A) * (D - B) + (G - E) * (H - F) - area_overlap;
	}
	public static int helper(int B, int D, int F, int H) {
		int hight = 0;
		if (D > H) {
			if (B > F) {
				hight = H - B;
			} else {
				hight = H - F;
			}
		} else {
			if (B > F) {
				hight = D - B;
			} else {
				hight = D - F;
			}
		}
		return hight;
	}

}
