package tree.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
/**
 *  Using minHeap and maxHeap to get TopK of a stream(unlimited)
 *  
 * @author carllee1991
 *
 */
public class StreamTopK {
	PriorityQueue<Integer> minHeap, maxHeap;
	double ratio;
	public StreamTopK(){
		this(0.5);
	}
	public StreamTopK(double ratio){
		minHeap = new PriorityQueue<Integer>(10);

		maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return b-a;
			}
		});
		this.ratio = ratio;
	}
	public void insert(int current){
		if(maxHeap.size()==0){
			maxHeap.offer(current);
			return;
		}
		double r = (double)maxHeap.size()/(minHeap.size()+maxHeap.size());
		if(r<ratio){
			if(!minHeap.isEmpty() && current<minHeap.peek())	maxHeap.offer(current);
			else{
				int temp = minHeap.poll();
				minHeap.offer(current);
				maxHeap.offer(temp);
			}
		}
		else{
			if(current>maxHeap.peek())	minHeap.offer(current);
			else{
				int temp = maxHeap.poll();
				minHeap.offer(temp);
				maxHeap.offer(current);
			}
		}
	}
	
	public int getIntAtRatio(){
		return maxHeap.peek();
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double ratio = sc.nextDouble();
		StreamTopK test = new StreamTopK(ratio);
		Random r = new Random();
		int cnt = 40;
		while(cnt>=0){
			int N = r.nextInt(100);
			test.insert(N);
			System.out.println(N+": "+test.getIntAtRatio());
			cnt--;
		}
	}
}
