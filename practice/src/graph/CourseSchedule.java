package graph;

/**
 * 207
 * https://leetcode.com/problems/course-schedule/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 * 
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * 
 * There are several ways to represent a graph.
 * https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs
 * For example, the input prerequisites is a graph represented by a list of edges.
 * Is this graph representation appropriate?
 * 
 * Topological Sort via DFS - A great video tutorial (21 minutes)
 * on Coursera explaining the basic concepts of Topological Sort.
 * https://class.coursera.org/algo-003/lecture/52
 * 
 * Topological sort could also be done via BFS.
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
