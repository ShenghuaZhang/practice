package google;
/**
 * 2
 * https://docs.google.com/file/d/0BwTHFkU-BZ7MaTgxWkZxOFIwV3c/edit
 */
import java.util.HashMap;
import java.util.Map;

class tree{
	int a, b;
	public tree(int x, int y){
		a=x;
		b=y;
	}
}

public class GetFriendsCircle {
	private static int find(int[] A, int a){
		if(A[a] == a)	return A[a];
		A[a] = find(A, A[a]);
		return A[a];
	}
	
	public static void printforest(tree[] t){
		Map<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for(int i=0; i<t.length; i++){
			if(!map.containsKey(t[i].a)){
				map.put(t[i].a, t[i].a);
				cnt ++;
			}
			if(!map.containsKey(t[i].b)){
				map.put(t[i].b, t[i].b);
				cnt ++;
			}
		}
		int[] array = new int[cnt+1];
		cnt = 1;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int num = entry.getKey();
			array[cnt++] = num;
		}
		
		for(int i=0; i<t.length; i++){
			int aIndex = find(array, t[i].a);
			int bIndex = find(array, t[i].b);
			if(aIndex!= bIndex)	array[t[i].b] = aIndex;
		}
		for(int i=1; i<array.length; i++) find(array, i);
		
		for(int i=1; i<cnt; i++)	System.out.print(array[i]+"  ");
	}
	
	public static void main(String[] args){
		tree[] forest = new tree[]{new tree(1, 2),new tree(2, 3),new tree(3, 4),new tree(5, 6), 
				new tree(7, 8),new tree(1, 9),new tree(7, 5)};
		
		printforest(forest);
	}
}