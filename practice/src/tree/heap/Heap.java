package tree.heap;

public class Heap<Key> {
	private Key[] heapArray;
	private final int defaultSize=100;
	private int maxSize;
	private int currentSize;
	
	@SuppressWarnings("unchecked")
	public Heap(){
		maxSize = defaultSize;
		heapArray = (Key[])new Object[maxSize];
		currentSize = 0;
	}
	
	@SuppressWarnings("unchecked")
	public Heap(int x){
		maxSize = x;
		heapArray = (Key[])new Object[maxSize];
		currentSize = 0;
	}
	
	public boolean isEmpty(){
		return currentSize==0;
	}
	
	public void insert(Key k){
		if(currentSize == maxSize)	doubleHeapArray(k);
		heapArray[currentSize] = k;
		trickleUp(currentSize++);
	}
	
	public void doubleHeapArray(Key k){
		@SuppressWarnings("unchecked")
		Key[] newHeapArray = (Key[])new Object[currentSize*2];
		maxSize = currentSize*2;
		for(int i=0; i<currentSize; i++)
			newHeapArray[i] = heapArray[i];
		heapArray = newHeapArray;
	}
	
	public void trickleUp(int index){
		int parent = (index-1)/2;
		Key bottom = heapArray[index];
		while(index>0 && heapArray[parent].()<bottom.getValue()){
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;
	}
	
	public Key remove(){
		if(currentSize == 0)	return null;
		Key root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		Key top = heapArray[index];
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
