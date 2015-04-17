package thread;
/**
 * http://blog.csdn.net/caohaicheng/article/details/38071097
 * @author carllee1991
 *
 */

class ThreadFirst extends Thread{
	public void run(){
		for(int i=0; i<100; i++)	System.out.println("thread1: "+i);
	}
}
class ThreadSecond extends Thread{
	public void run(){
		for(int i=0; i<100; i++) System.out.println("thread2: "+i);
	}
}
public class ThreadTest1 {
	public static void main(String[] args){
		ThreadFirst first = new ThreadFirst();
		first.start();
		ThreadSecond second = new ThreadSecond();
		second.start();
		for(int i=0; i<100; i++) System.out.println("main: "+i);
	}
}
