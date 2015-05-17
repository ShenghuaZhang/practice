package graph;

import java.util.Arrays;

/**
 * 210
 * 
 * @author carllee1991
 * 
 * #CourseSchedule
 *
 */
public class CourseScheduleII {
	public static int[] findOrder(int numCourses, int[][] prerequisites){
		int[][] matrix = new int[numCourses][numCourses];
		int[] courseOrder = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
		}
		int[] pointToMe = new int[numCourses];
		boolean[] finished = new boolean[numCourses];
		/* every node gets the # of nodes point to me */
		for (int i = 0; i < numCourses; i++)
			for (int j = 0; j < numCourses; j++)
				if (matrix[i][j] > 0)	pointToMe[j]++;
		int cnt = 0;
		for (int i = 0, k = 0; i < numCourses; i++) {
			if (!finished[i] && pointToMe[i] == 0) {
				courseOrder[k++] = i;
				finished[i] = true;
				for (int j = 0; j < numCourses; j++) {
					if (matrix[i][j] > 0)	pointToMe[j]--;
				}
				cnt++;
				i = -1;
			}
		}
		
		if(cnt!=numCourses)	return new int[numCourses];
		return courseOrder;
	}
	
	public static void main(String[] args){
		int[][] prerequisites = new int[4][4];
		prerequisites[0][0] = 1;
		prerequisites[0][1] = 0;
		
		prerequisites[1][0] = 2;
		prerequisites[1][1] = 0;
		
		prerequisites[2][0] = 3;
		prerequisites[2][1] = 1;
		
		prerequisites[3][0] = 3;
		prerequisites[3][1] = 2;
		
		int numCourses = 4;
		System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
	}
}
