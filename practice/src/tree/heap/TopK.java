package tree.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class TopK<E extends Comparable> {
	private PriorityQueue<E> queue;
	private int maxSize;
	
	@SuppressWarnings("unchecked")
	public TopK(int maxSize){
		if(maxSize<=0)	throw new IllegalArgumentException();
		this.maxSize = maxSize;
		this.queue = new PriorityQueue(maxSize, new Comparator<E>(){
			public int compare(E o1, E o2){
				return (o2.compareTo(o1));
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public void add(E e){
		if(queue.size()<maxSize)	queue.add(e);
		else{
			E peek = queue.peek();
			if(e.compareTo(peek)<0){
				queue.poll();
				queue.offer(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> sortedList(){
		List<E> list = new ArrayList<E>(queue);
		Collections.sort(list);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		final TopK pq = new TopK(10);
		Random rand = new Random();
		int rNum = 0;
		for(int i=0; i<10; i++){
			rNum = rand.nextInt(100);
			pq.add(rNum);
		}
		Iterable<Integer> iter = new Iterable<Integer>(){
			public Iterator<Integer> iterator(){
				return pq.queue.iterator();
			}
		};
		for(Integer it:iter)	System.out.print(it+", ");
		System.out.println();
		while(!pq.queue.isEmpty())	System.out.print(pq.queue.poll()+", ");
	}
}
