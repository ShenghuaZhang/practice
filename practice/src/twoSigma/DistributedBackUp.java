package twoSigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistributedBackUp {
	public static void main(String[] args) throws Exception{
		List<Set<Integer>> inputsets = new ArrayList<>();
//		Set<Integer> inputdata = new HashSet<>();
		Map<Integer, Integer> reversedIndex = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int num = Integer.parseInt(line);
		
		for(int i=0; i<num; i++){
			String[] data = br.readLine().split(" ");
			Set<Integer> hs = new HashSet<Integer>(data.length);
			inputsets.add(hs);
			if(data.length==1)	continue;
			
			int size = Integer.parseInt(data[0]);
			for(int j=1; j<size+1; j++){
				int tmp = Integer.parseInt(data[j]);
				hs.add(tmp);
//				inputdata.add(tmp);
				if(!reversedIndex.containsKey(tmp))
					reversedIndex.put(tmp, i+1);
			}
		}
//		System.out.println("inputdata"+inputdata);
//		System.out.println("reversedIndex"+reversedIndex);
//		for(int i=0; i<inputsets.size(); i++){
//			Set<Integer> s = inputsets.get(i);
//			for(Integer j: inputdata){
//				if(!s.contains(j))
//					System.out.println(j+" "+reversedIndex.get(j)+" "+(i+1));
//			}
//		}
		for(int i=0; i<inputsets.size(); i++){
			Set<Integer> s = inputsets.get(i);
			for(Map.Entry<Integer, Integer> entry : reversedIndex.entrySet()){
				int temp = entry.getKey();
				if(!s.contains(temp))
					System.out.println(temp+" "+reversedIndex.get(temp)+" "+(i+1));
			}
		}
		
		System.out.println("done");
	}
}
