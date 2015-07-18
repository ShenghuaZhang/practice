package stack;

import java.util.Stack;

/**
 * 155
 * https://leetcode.com/problems/min-stack/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * @author jiakangze
 *
 */

public class MinStack {

	public static void main(String[] args) {
		
		Integer i = new Integer(1);
		Integer k = new Integer(1);
		System.out.println(i == k);
		
		Integer m = 1;
		Integer n = 1;
		System.out.println(m == n);
		
		Integer m1 = 22222;
		Integer n1 = 22222;
		System.out.println(m1 == n1);
		
	}

}
class MinStack_leetcode {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
    	if (minStack.empty() || x <= minStack.peek()) {
    		minStack.push(x);
    	}
    	stack.push(x);
    	
    }

    public void pop() {
    	if (stack.pop().equals( minStack.peek())) {//in here, we can not use ==, because this is Integer not int. refer the above example.
    		minStack.pop();
    	}
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}