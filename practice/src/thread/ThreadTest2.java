package thread;

public class ThreadTest2 {  
    public static void main(String[] args){  
        ThreadA  t1=new ThreadA();  
        t1.start();
		synchronized(t1){
			try {
				t1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			t1.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ThreadB  t2=new ThreadB();  
        t2.start();  
    }  
}  
  
class ThreadA extends Thread{  
    @Override  
    public void run(){  
        for(int i=0;i<4;i++){  
            account.add();  
            try {  
                sleep(100);
            } catch (InterruptedException e) { 
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
class ThreadB extends Thread{
    @Override  
    public void run() {  
        for(int i=0;i<4;i++){  
            account.remove();  
            try {  
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
class account {  
    public static int count=1000;  
      
    public static synchronized void remove(){
        count=count-100;  
        System.out.println("After withdraw 100: "+count);  
    }  
       
    public static synchronized void add(){  
        count=count+100;  
        System.out.println("After add 100: "+count);  
    }  
}  
