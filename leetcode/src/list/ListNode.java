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
	
	public static void initial(ListNode head){
		head.val = 0;
		ListNode a = new ListNode(1), b = new ListNode(2);
		ListNode c = new ListNode(3), d = new ListNode(4);
		ListNode e = new ListNode(5), f = new ListNode(6);
		ListNode g = new ListNode(7), h = new ListNode(8);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
	}
}
