package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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
	
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if(node == null)    return null;
        Stack<UndirectedGraphNode> stack = new Stack<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        map.put(node, new UndirectedGraphNode(node.label));
        stack.push(node);
        
        while(!stack.isEmpty()){
            UndirectedGraphNode current = stack.pop();
            for(int i=0; i<current.neighbors.size(); i++){
                if(!map.containsKey(current.neighbors.get(i))){
                    map.put(current.neighbors.get(i), new UndirectedGraphNode(current.neighbors.get(i).label));
                    stack.push(current.neighbors.get(i));
                }
                map.get(current).neighbors.add(map.get(current.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
	
	public UndirectedGraphNode cloneGraphDFSRecursion(UndirectedGraphNode node){
		if(node == null)	return node;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		map.put(node, new UndirectedGraphNode(node.label));
		helper(node, map);
		
		return map.get(node);
	}
	private void helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
		for(int i=0; i<node.neighbors.size(); i++){
			if(!map.containsKey(node.neighbors.get(i))){
				map.put(node.neighbors.get(i), new UndirectedGraphNode(node.neighbors.get(i).label));
				helper(node.neighbors.get(i), map);
			}
			map.get(node).neighbors.add(map.get(node.neighbors.get(i)));
		}
	}
}
