package tree.binarytree;

public class BST {
	public TreeNode sortedArrayToBST(int[] Num){
		int length = Num.length;
		if (length == 0 || Num == null) return null;
		return sortedArrayToBSThelper(Num, 0, length-1);
	}

	private TreeNode sortedArrayToBSThelper(int[] Num, int begin,
			int end) {
		if (begin > end) return null;
		
		TreeNode root = new TreeNode(Num[(begin + end)/2]);
		root.left = sortedArrayToBSThelper(Num, begin, (begin+end)/2-1);
		root.right = sortedArrayToBSThelper(Num, (begin+end)/2+1, end);
		return root;
	}
}
