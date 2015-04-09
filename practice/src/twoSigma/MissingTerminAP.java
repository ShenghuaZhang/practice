package twoSigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class MissingTerminAP {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        Vector<Integer> ap = new Vector<>();
        for(String str : numbers)   ap.add(Integer.parseInt(str));
        
        int first = ap.get(0);
        int last = ap.get(ap.size()-1);
        int incr = (last-first)/num;
        for( int i=first; ; i+=incr){
            if(!ap.contains(i)){
                System.out.println(i);
                break;
            }
        }
    }
}
