package graph;

/**
 * 207
 * https://leetcode.com/problems/course-schedule/
 * 
 * @author carllee1991
 *
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
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
		for (int i = 0; i < numCourses; i++) {
			if (!finished[i] && pointToMe[i] == 0) {
				finished[i] = true;
				for (int j = 0; j < numCourses; j++) {
					if (matrix[i][j] > 0)	pointToMe[j]--;
				}
				cnt++;
				i = -1;
			}
		}
		return cnt == numCourses;
	}
}
