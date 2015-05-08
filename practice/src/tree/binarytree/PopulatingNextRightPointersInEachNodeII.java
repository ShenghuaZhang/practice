package tree.binarytree;
/**
 * 117
 * https://leetcode.com/submissions/detail/22065025/
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:	You may only use constant extra space.
 * 
 * #PopulatingNextRightPointersInEachNode
 */
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
	// using level order traversal
	public void connect(TreeLinkNode root) {
		if(root==null)  return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode previous = null;
            for(int i=0; i<size; i++){
                TreeLinkNode current = queue.poll();
                if(previous!=null)  previous.next = current;
                previous = current;
                if(current.left!=null)  queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
        }
	}
	
	//better solution with only O(1) space complexity
	public void connectII(TreeLinkNode root) {
		if (root == null)	return;
		TreeLinkNode parent = root, currentHead = null, current = null;
		
		while (parent != null) {
			if (parent.left != null) {
				if (currentHead == null) {
					currentHead = parent.left;
					current = currentHead;
				} else {
					current.next = parent.left;
					current = current.next;
				}
			}
			if (parent.right != null) {
				if (currentHead == null) {
					currentHead = parent.right;
					current = currentHead;
				} else {
					current.next = parent.right;
					current = current.next;
				}
			}
			if (parent.next == null) {
				if (current == null)	return;
				parent = currentHead;
				currentHead = null;
			} else
				parent = parent.next;
		}
	}
}
