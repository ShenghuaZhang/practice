package test;

public class PrimitiveAndWrappers {
	// Wrappers have considerable advantages in that primitive types can be
	// treated in a way similar to class types.
	// But they do take extra space and time, which may be an issue in some
	// circumstances.
	public static final int N = 25000;

	public static long freemem() {
		System.gc();
		return Runtime.getRuntime().freeMemory();
	}

	// without wrappers

	public static void test01() {
		long start_mem = freemem();
		int vec[] = new int[N];
		for (int i = 0; i < N; i++)
			vec[i] = i;
		long end_mem = freemem();
		long n = (start_mem - end_mem) / N;
		System.out.println("bytes per element = " + n);
	}

	// with wrappers
	public static void test02() {
		long start_mem = freemem();
		Integer vec[] = new Integer[N];
		for (int i = 0; i < N; i++)
			vec[i] = new Integer(i);
		long end_mem = freemem();
		long n = (start_mem - end_mem) / N;
		System.out.println("bytes per element = " + n);
	}

	// This program uses a system method freeMemory() that returns the amount of
	// memory currently free. We force a garbage collection via System.gc() to
	// make the figure more reliable. As we mentioned in issue #004, this
	// technique for determining memory use per element should be used
	// cautiously.

	public static void main(String args[]) {
		test01();
		test02();
	}

}