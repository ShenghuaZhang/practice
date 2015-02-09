package tree.binarytree;

public class BiTreeNode {
	public int data;
	public BiTreeNode leftNode;
	public BiTreeNode rightNode;
	
	public BiTreeNode(){
		leftNode = null;
		rightNode = null;
	}
	
	public BiTreeNode(int data, BiTreeNode leftNode, BiTreeNode rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}