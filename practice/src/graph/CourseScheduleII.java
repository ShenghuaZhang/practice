package graph;

import java.util.Arrays;

/**
 * TODO 210
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * 
 * @author carllee1991
 * 
 *         #CourseSchedule
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
		
		if(cnt!=numCourses)	return new int[]{};
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
