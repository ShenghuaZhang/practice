package stack;

import java.util.Stack;

public class MinStack{
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int x){
		stack.push(x);
		if(minStack.peek() >= x || minStack.isEmpty())	minStack.push(x);
	}
	public void pop(){
		if(stack.pop().equals(minStack.peek()))	minStack.pop();
	}
	public int top(){
		return stack.peek();
	}
	public int getMin(){
		return minStack.peek();
	}
	
}
