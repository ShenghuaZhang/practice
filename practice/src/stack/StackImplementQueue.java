package stack;

import java.util.NoSuchElementException;
import java.util.Stack;

public class StackImplementQueue<Key> {
	private Stack<Key> saveStack;
	private Stack<Key> getStack;
	
	public StackImplementQueue(){
		saveStack = new Stack<Key>();
		getStack = new Stack<Key>();
	}
	public void add(Key k){
		this.offer(k);
	}
	public void offer(Key k){
		saveStack.push(k);
	}
	public Key poll(){
		if(saveStack.empty() && getStack.empty())
			throw new NoSuchElementException("queue is empty");
		if(getStack.empty()){
			while(!saveStack.empty())
				getStack.push(saveStack.pop());
		}
		return getStack.pop();
	}
	public Key peek(){
		if(saveStack.empty() && getStack.empty())
			throw new NoSuchElementException("queue is empty");
		if(getStack.empty()){
			while(!saveStack.empty())
				getStack.push(saveStack.pop());
		}
		return getStack.peek();
	}
}
