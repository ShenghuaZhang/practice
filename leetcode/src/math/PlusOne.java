package math;

import java.util.List;

public class PlusOne {
	public void plusOne(List<Integer> digits){
		for(int i=digits.size()-1; i>=0; i--){
			int temp = digits.get(i)+1;
			if(temp <= 9){
				digits.set(i, temp);
				return;
			}
			else digits.set(i, 0);
		}
		digits.add(0, 1);
	}
}
