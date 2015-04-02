package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Clone an undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * @author yili3
 *
 */
public class CloneGraph {
	class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node){
		if(node == null)	return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		queue.offer(node);
		while(!queue.isEmpty()){
			UndirectedGraphNode cur = queue.poll();
			for(int i=0; i<cur.neighbors.size();i++){
				if(!map.containsKey(cur.neighbors.get(i))){
					copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
					map.put(cur.neighbors.get(i), copy);
					queue.offer(cur.neighbors.get(i));
				}
				map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
			}
		}
		return map.get(node);
	}
}
