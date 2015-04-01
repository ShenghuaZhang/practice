package snapchat;

import java.util.ArrayList;
import java.util.List;

public class ZeroOne {
	static long getZeroOne(int ip) {
		List<Long> array = new ArrayList<>();
		List<Long> array1 = new ArrayList<>();

		long mul_val = 10;

		array.add((long) 0);
		array.add((long) 1);
		while(true){
			for(long c : array){
				long num = mul_val+c;
				if((num%ip) == 0)	return num;
				array1.add(c);
				array1.add(num);
			}
			array.clear();
			array.addAll(array1);
			mul_val*=10;
		}
	}
	
	static long getZeroOneMod(int n) {
        for(int i=1;;i++){
        	String binary=Integer.toBinaryString(i);
        	Long no=Long.parseLong(binary);
        	if(no % n == 0)	return no;
        }
    }
	
	public static void main(String[] args){
		System.out.print(getZeroOne(45));
	}
}
