package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Entry{
	String name;
	public int time;
	public String type;
	public Entry(String name, int time, String type){
		this.name = name;
		this.time = time;
		this.type = type;
	}
}

public class Profiling {
	public static void profiling(Entry[] e){
		Map<String, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<e.length; i++)
			if(e[i].type.equals("end"))
				map.put(e[i].name, e[i].time);
		
		for(int i=0; i<e.length; i++){
			if(e[i].type.equals("end")) continue;
			int period = map.get(e[i].name)-e[i].time;
			
			while(!stack.empty() && stack.peek()<e[i].time)	stack.pop();
			for(int k=stack.size(); k>0; k--)	System.out.print(" ");
			
			System.out.println(e[i].name+" "+period);
			stack.push(map.get(e[i].name));
		}
	}
	
	public static void main(String[] args){
		Entry[] e = new Entry[6];
		e[0] = new Entry("main", 0, "start");
		e[1] = new Entry("foo", 5, "start");
		e[2] = new Entry("foo", 50, "end");
		e[3] = new Entry("bar", 60, "start");
		e[4] = new Entry("bar", 90, "end");
		e[5] = new Entry("main", 100, "end");
		
		profiling(e);
	}
}
