package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Job{
	int start;
	int end;
	int processors;
	public Job(int start, int end, int need){
		this.start = start;
		this.end = end;
		this.processors = need;
	}
	public int getStart(){
		return start;
	}
	public int getEnd(){
		return end;
	}
	public int getNeed(){
		return processors;
	}
	public List<Status> toStatus(){
		List<Status> list = new ArrayList<>();
		list.add(new Status(start, processors));
		list.add(new Status(end, -processors));
		return list;
	}
}

class Status {
	int time;
	int processors;

	public Status(int time, int need) {
		this.time = time;
		this.processors = need;
	}
}

public class MaxNeed {
	public static int maxNeed(List<Job> list){
		List<Status> helper = new ArrayList<>();
		for(int i=0; i<list.size(); i++)
			helper.addAll(list.get(i).toStatus());
		
		Comparator<Status> cmp = new Comparator<Status>(){
			public int compare(Status h1, Status h2){
				return h1.time-h2.time;
			}
		};
		Collections.sort(helper, cmp);
		
		int max = 0, current=0;
		for(int i=0; i<helper.size(); i++){
			current += helper.get(i).processors;
			max = Math.max(max, current);
		}
		
		return max;
	}
	
	public static void main(String[] args){
		final Job job1= new Job(0, 3, 2), job2 = new Job(2, 7, 1),
				job3 = new Job(4, 6, 3), job4 = new Job(5, 7, 1);
		List<Job> list = new ArrayList<Job>(){
			private static final long serialVersionUID = -1939229643468084907L;
		{
			add(job1);	add(job2); add(job3); add(job4);
			}
		};
		
		System.out.print(maxNeed(list));
	}
}
