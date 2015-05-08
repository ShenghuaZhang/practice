package list;

public class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x){
		this.label = x;
	}
	
	public static void print(RandomListNode head){
		while(head!=null){
			System.out.print(head.label+" ");
			head = head.next;
		}
	}
}
