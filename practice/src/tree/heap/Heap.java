package tree.heap;

class HeapNode {
	private int value;
	public HeapNode(int x){
		value = x;
	}
	public int getValue(){
		return value;
	}
	public void setValue(int x){
		value = x;
	}
}

public class Heap {
	private HeapNode[] heapArray;
	private final int defaultSize=100;
	private int maxSize;
	private int currentSize;
	
	public Heap(){
		maxSize = defaultSize;
		heapArray = new HeapNode[maxSize];
		currentSize = 0;
	}
	
	public Heap(int x){
		maxSize = x;
		heapArray = new HeapNode[maxSize];
		currentSize = 0;
	}
	
	public boolean isEmpty(){
		return currentSize==0;
	}
	
	public void insert(int x){
		if(currentSize == maxSize)	doubleHeapArray(x);
		heapArray[currentSize] = new HeapNode(x);
		trickleUp(currentSize++);
	}
	
	public void doubleHeapArray(int x){
		HeapNode[] newHeapArray = new HeapNode[currentSize*2];
		maxSize = currentSize*2;
		for(int i=0; i<currentSize; i++)
			newHeapArray[i] = heapArray[i];
		heapArray = newHeapArray;
	}
	
	public void trickleUp(int index){
		int parent = (index-1)/2;
		HeapNode bottom = heapArray[index];
		while(index>0 && heapArray[parent].getValue()<bottom.getValue()){
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;
	}
	
	public HeapNode remove(){
		if(currentSize == 0)	return null;
		HeapNode root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		HeapNode top = heapArray[index];
		int largerChild;
		while(index < currentSize/2){
			int left = 2*index +1, right = 2*index+2;
			if(right<currentSize && heapArray[left].getValue()>heapArray[right].getValue())
				largerChild = left;
			else largerChild = right;
			
			if(top.getValue()<heapArray[largerChild].getValue()){
				heapArray[index] = heapArray[largerChild];
				index = largerChild;
			}else break;
		}
		heapArray[index] = top;
	}
	
	public boolean change(int index, int value){
		if(index<0 || index >= currentSize)	return false;
		int oldValue = heapArray[index].getValue();
		heapArray[index].setValue(value);
		if(value > oldValue)
			trickleUp(index);
		else trickleDown(index);
		return true;
	}
	
	public void print(){
		for(int i=0; i<currentSize; i++)
			System.out.print(i+": "+heapArray[i].getValue()+"  ");
	}
}
