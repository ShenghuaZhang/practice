package tree.binarytree;
/**
 * 116
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Given a binary tree
 *     struct TreeLinkNode {
 *        TreeLinkNode *left;
 *        TreeLinkNode *right;
 *        TreeLinkNode *next;
 *     }
 * 
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree
 * (ie, all leaves are at the same level, and every parent has two children).

 * @author carllee1991
 *
 * #PopulatingNextRightPointersInEachNodeII
 * 
 */
public class PopulatingNextRightPointersInEachNode {
	public void connectI(TreeLinkNode root) {
		if (root == null)	return;

		TreeLinkNode parentHead = root, parent = parentHead;

		while (parent.left != null) {
			parent.left.next = parent.right;
			if (parent.next == null) {
				parentHead = parentHead.left;
				parent = parentHead;
			} else {
				parent.right.next = parent.next.left;
				parent = parent.next;
			}
		}
	}
}
