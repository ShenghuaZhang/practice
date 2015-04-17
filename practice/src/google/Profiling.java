package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Entry{
	String name;
	public int time;
	public boolean type;
	public Entry(String name, int time, boolean type){
		this.name = name;
		this.time = time;
		this.type = type;
	}
}

class outPut{
	String name;
	int startTime;
	int time;
	int block;
	public outPut(String name, int startTime, int time, int block){
		this.name = name;
		this.startTime = startTime;
		this.time = time;
		this.block = block;
	}
}

public class Profiling {
	public static void profiling(Entry[] e){
		List<Entry> currentEx = new ArrayList<>();
		List<outPut> res = new ArrayList<>();
		
		for(int i=0; i<e.length; i++){
			if(e[i].type){
				currentEx.add(e[i]);
			}else {
				Entry startEntry = currentEx.get(currentEx.size()-1);
				currentEx.remove(currentEx.size()-1);
				int period = e[i].time - startEntry.time;
				res.add(new outPut(startEntry.name, startEntry.time, period, currentEx.size()));
			}
		}
		
		Comparator<outPut> cmp = new Comparator<outPut>(){
			public int compare(outPut o1, outPut o2){
				return o1.startTime-o2.startTime;
			}
		};
		Collections.sort(res, cmp);
		
		for(int i=0; i<res.size(); i++){
			for(int j=res.get(i).block; j>0; j--)	System.out.print(" ");
			System.out.println(res.get(i).name+"    "+res.get(i).time);
		}
	}
	
	public static void main(String[] args){
		Entry[] e = new Entry[6];
		e[0] = new Entry("main", 0, true);
		e[1] = new Entry("foo", 5, true);
		e[2] = new Entry("foo", 50, false);
		e[3] = new Entry("bar", 60, true);
		e[4] = new Entry("bar", 90, false);
		e[5] = new Entry("main", 100, false);
		
		profiling(e);
	}
}
