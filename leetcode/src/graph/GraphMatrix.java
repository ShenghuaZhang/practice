package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphMatrix {
	private int[][] matrix;
	private int nodeNum;
	
	public GraphMatrix(int n){
		matrix = new int[n][n];
		nodeNum = n;
	}
	public GraphMatrix(int[][] matrix){
		this.matrix = new int[matrix.length][matrix.length];
		nodeNum = matrix.length;
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix.length; j++)
				this.matrix[i][j] = matrix[i][j];
	}
	
	public void addEdge(int i, int j, int value){
		if(i>=nodeNum || j>=nodeNum)	return;
		matrix[i][j] = value;
	}
	public void deleteEdge(int i, int j){
		if(i>=nodeNum || j>=nodeNum)	return;
		matrix[i][j] = 0;
	}
	
	public int getEdgeValue(int i, int j){
		if(i>=nodeNum || j>=nodeNum)	return -1;
		return matrix[i][j];
	}
	
	public boolean hasPath(int vertex1, int vertex2){
		return getMinimumDistance(vertex1, vertex2)>0?true:false;
	}
	
	public int getMinimumDistance(int vertex1, int vertex2){
		List<List<Integer>> list = new ArrayList<>();
		dfs(vertex1, vertex2, list, new ArrayList<Integer>());
		int min = Integer.MAX_VALUE;
		for(int i=0; i<list.size(); i++){
			int temp = 0;
			for(int j=0; j<list.get(i).size()-1; j++)
				temp += matrix[list.get(i).get(j)][list.get(i).get(j+1)];
			min = Math.min(min, temp);
		}
		return (list.size()==0)?-1:min;
	}
	private void dfs(int vertex1, int vertex2, List<List<Integer>> list, List<Integer> current){
		if(vertex1==vertex2){
			current.add(vertex1);
			list.add(new ArrayList<Integer>(current));
			current.remove(current.size()-1);
			return;
		}
		for(int i=0; i<nodeNum; i++){
			if(matrix[vertex1][i]>0){
				current.add(vertex1);
				dfs(i, vertex2, list, current); // DFS
				current.remove(current.size()-1); // Backtracking
			}
		}
	}
	
	public boolean hasCircle(){
		int[] pointToMe = new int[nodeNum];
		boolean[] finished = new boolean[nodeNum];
		/*	every node gets the # of nodes point to me */
		for(int i=0; i<nodeNum; i++)
			for(int j=0; j<nodeNum; j++)
				if(matrix[i][j]>0)	pointToMe[j]++;
		int cnt=0;
		for(int i=0; i<nodeNum; i++){
			if(!finished[i] && pointToMe[i]==0){
				finished[i]= true;
				for(int j=0; j<nodeNum; j++){
					if(matrix[i][j]>0)	pointToMe[j]--;
				}
				cnt++;
				i=-1;
			}
		}
		return cnt!=nodeNum;
	}
	
	public List<Integer> topological(){
		List<Integer> list = new ArrayList<>();
		int[] pointToMe = new int[nodeNum];
		boolean[] finished = new boolean[nodeNum];
		for(int i=0; i<nodeNum; i++)
			for(int j=0; j<nodeNum; j++)
				if(matrix[i][j]>0)	pointToMe[j]++;
		for(int i=0; i<nodeNum; i++){
			if(!finished[i] && pointToMe[i]==0){
				finished[i] = true;
				list.add(i);
				for(int j=0; j<nodeNum; j++){
					if(matrix[i][j]>0)	pointToMe[j]--;
				}
				i=0;
			}
		}
		return list;
	}
	
	public void bfs(){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		boolean[] visited = new boolean[nodeNum];
		System.out.println("bfs: ");
		while(!queue.isEmpty()){
			int current = queue.poll();
			for(int i=0; i<nodeNum; i++){
				if(!visited[i] && matrix[current][i]>0){
					System.out.println("get edge from "+current+" to "+i);
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	public void dfs(){
		System.out.println("dfs: ");
		dfs(0, new boolean[nodeNum]);
	}
	public void dfs(int vertex, boolean[] visited){
		visited[vertex] = true;
		for(int j=0; j<nodeNum; j++){
			if(!visited[j] && matrix[vertex][j]>0){
				System.out.println("get edge from "+vertex+" to "+j);
				dfs(j, visited);
			}
		}
	}
	
	public List<Integer> dijkstra(){
		return this.dijkstra(0);
	}
	public List<Integer> dijkstra(int start){
		List<Integer> list = new ArrayList<>();
		list.add(start);
		int[] distanceToStart = new int[nodeNum];
		for(int i=0; i<matrix.length; i++) distanceToStart[i] = matrix[start][i];
		int cnt = 1;
		while(cnt<nodeNum){
			int min = 0;
			for(int i=0; i<nodeNum; i++){
				if(distanceToStart[i]>0)
					if(min==0 || distanceToStart[i]<distanceToStart[min]) min = i;
			}
			for(int i=0; i<nodeNum; i++){
				if(matrix[min][i]>0 && (matrix[min][i]+distanceToStart[min]<distanceToStart[i]||distanceToStart[i]==0))
					distanceToStart[i] = matrix[min][i]+distanceToStart[min];
			}
			distanceToStart[min] = -1;
			list.add(min);
			cnt++;
		}
		System.out.println(list);
		return list;
	}
	
	public static void main(String[] args){
		GraphMatrix graph = new GraphMatrix(4);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 2);
		graph.addEdge(2, 1, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 2);
//		graph.addEdge(3, 2, 1);
		
		System.out.println("Get minimumDistance from 1 to 2"+graph.getMinimumDistance(1, 2));
		System.out.println("hasCircle(topo method): "+graph.hasCircle());
		System.out.println("topo order: "+graph.topological());
		graph.bfs();
		graph.dfs();
		graph.dijkstra();
	}
}
