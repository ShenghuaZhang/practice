package google;

import java.util.HashMap;
import java.util.Map;

class tree{
	int a, b;
	public tree(int x, int y){
		a=x;
		b=y;
	}
}

public class GetForestCircle {
	public static void printforest(tree[] t){
		Map<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for(int i=0; i<t.length; i++){
			if(!map.containsKey(t[i].a)){
				map.put(t[i].a, i+1);
				cnt ++;
			}
			if(!map.containsKey(t[i].b)){
				map.put(t[i].b, i+1);
				cnt ++;
			}
		}
		int[][] array = new int[cnt][2];
		cnt = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int num = entry.getKey();
			array[cnt][0] = num;
			array[cnt++][1] = num;
		}
		
		for(int i=0; i<t.length; i++){
			int aIndex = getIndex(array, t[i].a);
			int bIndex = getIndex(array, t[i].b);

			for(int j=0; j<cnt; j++)
				if(array[j][0] == array[aIndex][0])
					array[j][0] = array[bIndex][0];
			array[aIndex][0] = array[bIndex][0];
		}
		
		for(int i=0; i<cnt; i++){
			System.out.println(array[i][0]+" "+array[i][1]);
		}
	}
	private static int getIndex(int[][] array, int val){
		for(int i=0; ; i++){
			if(array[i][1] == val)	return i;
		}
	}
	
	public static void main(String[] args){
		tree[] forest = new tree[]{new tree(1, 2),new tree(2, 3),new tree(3, 4),new tree(5, 6), 
				new tree(7, 8),new tree(1, 9),new tree(7, 5),};
		
		printforest(forest);
	}
}
