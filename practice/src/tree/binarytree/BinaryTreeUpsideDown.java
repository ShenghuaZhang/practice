package tree.binarytree;
/**
 * 156
 * https://leetcode.com/problems/binary-tree-upside-down/
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with
 * a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes
 * turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1  
 * 
 * @author yili3
 *
 */
public class BinaryTreeUpsideDown {
	public static TreeNode UpsideDownBinaryTree(TreeNode root){
		TreeNode p = root, parent = null, parentRight = null;
		while(p != null){
			TreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}

	public static TreeNode UpsideDownBinaryTreeBottomUp(TreeNode root){
		return dfsBottomUpI(root, null);
	}
	private static TreeNode dfsBottomUpI(TreeNode p, TreeNode parent){
		if (p == null)	return parent;
		
		TreeNode root = dfsBottomUpI(p.left, p);
		p.left = (parent == null) ? null : dfsBottomUpI(parent.right, null);
		p.right = parent;
		
		return root;
	}
	
	public static void main(String[] args){
		System.out.println(Levelorder.levelorder(UpsideDownBinaryTreeBottomUp(TreeNode.LeetcodeInitialize("{1,2,3,4,5,6,7}"))));
	}
}
