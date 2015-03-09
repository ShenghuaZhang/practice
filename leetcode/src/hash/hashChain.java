package hash;

class LinklistNode{
	public int value;
	public LinklistNode next;
	public LinklistNode(int it){
		value = it;
	}
	public void DisplayLinklistNode(){
		System.out.print(value + " ");
	}
}

class SortedLinklist{
	private LinklistNode head;
	
	public SortedLinklist(){
		head = null;
	}
	
	public void insert(LinklistNode node){
		int key = node.value;
		LinklistNode previous = null, current = head;
		
		while(current!=null && key>current.value){
			previous = current;
			current = current.next;
		}
		if(previous==null)	head = node;
		else previous.next = node;
		node.next = current;
	}
	
	public LinklistNode find(int key){
		LinklistNode current = head;
		while(current!=null && current.value<=key){
			if(current.value == key)	return current;
			current = current.next;
		}
		return null;
	}
	
	public boolean delete(int key){
		LinklistNode previous = null, current = head;
		while(current!=null){
			if(current.value==key){
				if(previous == null)	head = head.next;
				else previous.next = current.next;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public void displayList(){
		LinklistNode current = head;
		while(current!=null){
			current.DisplayLinklistNode();
			current = current.next;
		}
		System.out.println();
	}
}

class HashChainTable{
	
}

public class hashChain {
}
