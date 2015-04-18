package tree.binarytree;
/**
 * https://leetcode.com/submissions/detail/22065025/
 */
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	// using level order traversal, but not the best, because in next solution
	// we have space complexity only O(1) better than our O(n)
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.add(root);
		root.next = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode first = queue.poll();
			for (int i = 1; i <= size; i++) {
				if (first.left != null) {
					queue.add(first.left);
					queue.add(first.right);
					first.left.next = first.right;
				} else
					return;
				if (i < size) {
					TreeLinkNode second = queue.poll();
					first.right.next = second.left;
					first = second;
				} else
					first.right.next = null;
			}
		}
	}

	// better solution
	public void connectI(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;

		TreeLinkNode parentHead = root, parent = parentHead;

		while (parent.left != null) {
			parent.left.next = parent.right;
			if (parent.next == null) {
				parent.right.next = null;
				parentHead = parentHead.left;
				parent = parentHead;
			} else {
				parent.right.next = parent.next.left;
				parent = parent.next;
			}
		}
	}

	public void connectII(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;

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
				if (current == null)
					return;
				current.next = null;
				parent = currentHead;
				currentHead = null;
			} else
				parent = parent.next;
		}

	}
}
