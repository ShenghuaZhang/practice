package tree.binarytree;

public class Tree {
	public TreeNode root;
	
	public Tree(){
		this.root = null;
	}
	
	public Tree(int data, Tree leftchild, Tree rightchild){
		TreeNode left, right;
		if (leftchild == null)	left = null;
		else left = leftchild.root;
		
		if (rightchild == null)	right = null;
		else right = rightchild.root;
		
		this.root = new TreeNode(data, left, right);
	}
	
	public void insert(int data){
		TreeNode newNode = new TreeNode(data, null, null);
		TreeNode current = root;
		TreeNode parent = current;
		
		if (root == null){
			root = newNode;
			return;
		}else{
			while(true){
				parent = current;
				if (current.val > data){
					current = current.left;
					if (current == null){
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if (current == null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	public TreeNode find(int data){
		TreeNode current = root;
		
		while(current.val != data){
			if (current.val>data){
				current = current.left;
			}else{
				current = current.right;
			}
			
			if(current == null){
				throw new RuntimeException("Can not find this data.\n");
			}
		}
		
		return current;
	}
}
