package LinkedList;

/**
 * 138
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * @author kajia
 * 
 * http://stackoverflow.com/questions/6182565/deep-copy-shallow-copy-clone
 */

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static RandomListNode copyRandomList(RandomListNode head) {
        
    }

}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
