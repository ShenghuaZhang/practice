package queue;

class Queue{
	private int maxSize;
	private int[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s){
		queArray = new int[s];
		maxSize = s;
		nItems=0;
		front=0;
		rear=-1;
	}
	
	public void insert(int n){
		if(nItems==maxSize){
			System.err.println("Queue is full.");
			return;
		}
		if(rear==maxSize-1)	rear = -1;
		queArray[++rear] = n;
		nItems++;
	}
	
	public int remove(){
		int temp = queArray[front++];
		if(front==maxSize)	front=0;
		nItems--;
		return temp;
	}
	
	public int peek(){
		if(isEmpty()){
			System.err.println("Queue is empty.");
		}
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return (nItems==0);
	}
	
	public boolean isFull(){
		return (nItems==maxSize);
	}
	
	public int size(){
		return nItems;
	}
}

public class QueueByArray {

}
