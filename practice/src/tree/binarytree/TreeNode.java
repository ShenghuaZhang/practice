package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	
	public TreeNode(){
		left = null;
		right = null;
	}
	
	public TreeNode(int x){
		val = x;
	}

	public TreeNode(int data, TreeNode leftNode, TreeNode rightNode){
		this.val = data;
		this.left = leftNode;
		this.right = rightNode;
	}
	
	public void initialize(){
		val = 5;
		left = new TreeNode(2);
		right = new TreeNode(8);
		left.left = new TreeNode(1);
		left.right = new TreeNode(3);
		left.right.right = new TreeNode(4);
		right.left = new TreeNode(6);
		right.left.right = new TreeNode(7);
		right.right = new TreeNode(9);
		right.right.right = new TreeNode(10);
	}
	
	public static TreeNode testRoot(){
		TreeNode root = new TreeNode();
		root.val = 5;
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		return root;
	}
	
	public static TreeNode LeetcodeInitialize(String s){
		s = s.substring(1, s.length()-1);
		String[] ss = s.split(",");
		if (ss[0].equals("#"))	return null;
		TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
		int num = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty() && num<ss.length){
			TreeNode current = queue.poll();

			if(ss[num].equals("#"))	current.left = null;
			else {
				current.left = new TreeNode(Integer.parseInt(ss[num]));
				queue.add(current.left);
			}
			num++;
			if (num >= ss.length)	break;
			if(ss[num].equals("#"))	current.right = null;
			else {
				current.right = new TreeNode(Integer.parseInt(ss[num]));
				queue.add(current.right);
			}
			num++;
		}
		
		return root;
	}
	
	public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        
        if (current == null) return;
        queue.add(current);
        
        while(!queue.isEmpty()){
        	int size = queue.size();
        	for (int j = 0; j < size; j++){
        		current = queue.poll();
        		System.out.print(current.val+" ");
        		if (current.left != null)	queue.add(current.left);
        		if (current.right != null)	queue.add(current.right);
        	}System.out.println();
        }
    }
}
