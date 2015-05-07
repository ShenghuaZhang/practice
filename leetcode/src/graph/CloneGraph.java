package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 133
 * https://leetcode.com/problems/clone-graph/
 * 
 * Clone an undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * @author yili3
 *
 */
class UndirectedGraphNode{
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class CloneGraph {
	/* BFS Queue */
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node){
		if(node == null)	return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		
		map.put(node, new UndirectedGraphNode(node.label));
		queue.offer(node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode cur = queue.poll();
			for(int i=0; i<cur.neighbors.size();i++){
				if(!map.containsKey(cur.neighbors.get(i))){
					map.put(cur.neighbors.get(i), new UndirectedGraphNode(cur.neighbors.get(i).label));
					queue.offer(cur.neighbors.get(i));
				}
				map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
			}
		}
		return map.get(node);
	}
	
	/* DFS Recursion */
	public UndirectedGraphNode cloneGraphDFSRecursion(UndirectedGraphNode node){
		if(node == null)	return node;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		map.put(node, new UndirectedGraphNode(node.label));
		dfs(node, map);
		
		return map.get(node);
	}
	private void dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
		for(int i=0; i<node.neighbors.size(); i++){
			if(!map.containsKey(node.neighbors.get(i))){
				map.put(node.neighbors.get(i), new UndirectedGraphNode(node.neighbors.get(i).label));
				dfs(node.neighbors.get(i), map);
			}
			map.get(node).neighbors.add(map.get(node.neighbors.get(i)));
		}
	}
}