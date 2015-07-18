package stack;

import java.util.Stack;

/**
 * 232
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * 
 * @author jiakangze
 *
 */

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyQueue {
    // Push element x to the back of queue.
	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output = new Stack<Integer>();
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if (output.empty()) {
        	while (!input.empty()) {
        		output.push(input.pop());
        	}
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return output.empty() && input.empty();
    }
}
