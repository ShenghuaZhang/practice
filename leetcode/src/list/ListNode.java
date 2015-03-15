package list;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x)	{
		val = x;
		next = null;
	}
	public ListNode()	{
		next = null;
	}
	
	public static ListNode initial(){
		ListNode head = new ListNode(0);
		ListNode a = new ListNode(1), b = new ListNode(2);
		ListNode c = new ListNode(3), d = new ListNode(4);
		ListNode e = new ListNode(5), f = new ListNode(6);
		ListNode g = new ListNode(7), h = new ListNode(8);
		head.next = a;
		a.next = b;		b.next = c;		c.next = d;
		d.next = e;		e.next = f;		f.next = g;
		g.next = h;
		
		return head;
	}
	
	public static void print(ListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	
	public static ListNode LeetcodeInitialize(String s){
		s = s.substring(1, s.length()-1);
		String[] ss = s.split(",");
		ListNode head = new ListNode(Integer.parseInt(ss[0]));
		ListNode current = head;
		for(int i=1; i<ss.length; i++){
			current.next = new ListNode(Integer.parseInt(ss[i]));
			current = current.next;
		}
		
		return head;
	}
}
