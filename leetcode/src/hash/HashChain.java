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
	
	public void insert(int key){
		LinklistNode previous = null, current = head, node = new LinklistNode(key);
		
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
	private SortedLinklist[] hashArray;
	private int arraySize;
	
	public HashChainTable(int size){
		arraySize = size;
		hashArray = new SortedLinklist[arraySize];
		// TODO: Why need this?
		/* fill array with lists*/
		for(int j=0; j<arraySize; j++)	hashArray[j] = new SortedLinklist();
	}
	
	public void displayTable(){
		for(int j=0; j<arraySize; j++){
			System.out.print(j+".");
			hashArray[j].displayList();
		}
	}
	
	public int hashFunc(int key){
		return key % arraySize;
	}
	
	public void insert(int key){
		int location = key % arraySize;
		hashArray[location].insert(key);
	}
	
	public boolean delete(int key){
		int location = key % arraySize;
		return hashArray[location].delete(key);
	}
	
	public LinklistNode find(int key){
		int location = key % arraySize;
		return hashArray[location].find(key);
	}
}

public class HashChain {
	public static void main(String[] args){
		final int SIZE = 43, KEYSPRECELL = 5;
		HashChainTable table = new HashChainTable(SIZE);

		for (int j = 0; j < SIZE*2; j++)
			table.insert((int) (Math.random() * KEYSPRECELL * SIZE));
		
		table.displayTable();
	}
}
