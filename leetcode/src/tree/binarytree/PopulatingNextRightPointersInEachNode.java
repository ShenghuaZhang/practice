package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root){
		if (root == null)	return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.add(root);
		root.next = null;
		while(!queue.isEmpty()){
		    int size = queue.size();
			TreeLinkNode first = queue.poll();
			for(int i=1;i<=size;i++){
				if (first.left!= null){
					queue.add(first.left);
					queue.add(first.right);
					first.left.next = first.right;
				} else return;
				if (i<size){
					TreeLinkNode second = queue.poll();
					first.right.next = second.left;
					first = second;
				}else first.right.next = null;	
			}
		}
	}
	
	public void connectII(TreeLinkNode root){
		if (root == null)	return;
		TreeLinkNode lastHead = root;
		TreeLinkNode curHead = null;
		TreeLinkNode pre = null;
		while(lastHead!=null){
			TreeLinkNode lastCur = lastHead;
			while(lastCur != null){
				if (curHead == null){
					curHead = lastCur.left;
					pre = curHead;
				}else {
					pre.next = lastCur.left;
					pre = pre.next;
				}
				if (lastCur.right != null){
					if (curHead == null){
						curHead = lastCur.right;
						pre = curHead;
					}else {
						pre.next = lastCur.right;
						pre = pre.next;
					}
				}
				lastCur = lastCur.next;
			}
			
			lastHead = curHead;
			curHead = null;
		}
	}
}
