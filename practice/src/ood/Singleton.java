package ood;
/**
 * http://www.oodesign.com/singleton-pattern.html
 * 
 * @author carllee1991
 *
 */
//Lazy instantiation using double locking mechanism.
class TestSingleton{
	private static TestSingleton instance;

	private TestSingleton(){
		System.out.println("Singleton(): Initializing Instance");
	}

	public static TestSingleton getInstance(){
		if (instance == null){
			synchronized(TestSingleton.class){
				if (instance == null){
					System.out.println("getInstance(): First time getInstance was invoked!");
					instance = new TestSingleton();
				}
			}            
		}

		return instance;
	}

	public void doSomething(){
		System.out.println("doSomething(): Singleton does something!");
	}
}

class Singleton{
	public static void main(String[] args){
		TestSingleton first = TestSingleton.getInstance();
		first.doSomething();
	}
}
