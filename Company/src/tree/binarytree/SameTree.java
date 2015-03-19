package tree.binarytree;

import java.util.Stack;

public class SameTree {
	public static boolean isSameByRecursive(TreeNode p, TreeNode q){
		if (p == null && q == null) return true;
		if (p == null || q == null)	return false;
		if (p.val != q.val)	return false;
		return isSameByRecursive(p.left, q.left)&&isSameByRecursive(p.right, q.right);
	}
	
	public static boolean isSame(TreeNode p, TreeNode q){
		Stack<TreeNode> sp = new Stack<>(),sq = new Stack<>();
		if (p == null && q == null) return true;
		if (p == null || q == null)	return false;
		
		while((p!=null &&q!=null)||(!sp.isEmpty()&&!sq.isEmpty())){
			while (p!= null && q!=null){
				if (p.val != q.val) return false;
				sp.push(p);
				sq.push(q);
				p = p.left;
				q = q.left;
			}
			if (p == null && q == null){
				p = sp.pop().right;
				q = sq.pop().right;
			}else return false;
		}
		return (p==null)&&(q==null);
	}
}
