package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * @author kajia
 *
 */

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class MyStack {
    // Push element x onto stack.
	Queue<Integer> queue = new LinkedList<Integer>();
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size()-1; i++) {
        	queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}