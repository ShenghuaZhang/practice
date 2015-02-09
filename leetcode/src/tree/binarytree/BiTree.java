package tree.binarytree;

public class BiTree {
	public BiTreeNode root;
	
	public BiTree(){
		this.root = null;
	}
	
	public BiTree(int data, BiTree leftchild, BiTree rightchild){
		BiTreeNode left, right;
		if (leftchild == null)	left = null;
		else left = leftchild.root;
		
		if (rightchild == null)	right = null;
		else right = rightchild.root;
		
		this.root = new BiTreeNode(data, left, right);
	}
	
	public void insert(int data){
		BiTreeNode newNode = new BiTreeNode(data, null, null);
		BiTreeNode current = root;
		BiTreeNode parent = current;
		
		if (root == null){
			root = newNode;
			return;
		}else{
			while(true){
				parent = current;
				if (current.data > data){
					current = current.leftNode;
					if (current == null){
						parent.leftNode = newNode;
						return;
					}
				}else{
					current = current.rightNode;
					if (current == null){
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}
	}
	
	public BiTreeNode find(int data){
		BiTreeNode current = root;
		
		while(current.data != data){
			if (current.data>data){
				current = current.leftNode;
			}else{
				current = current.rightNode;
			}
			
			if(current == null){
				throw new RuntimeException("Can not find this data.\n");
			}
		}
		
		return current;
	}
}
