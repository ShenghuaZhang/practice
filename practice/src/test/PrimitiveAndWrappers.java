package test;
/**
 * test for contributor jia
 * @author carllee1991
 *
 */
public class PrimitiveAndWrappers {
	/*
	 * Wrappers have considerable advantages in that primitive types can be
	 * treated in a way similar to class types. But they do take extra space and
	 * time, which may be an issue in some circumstances.
	 * 
	 * This program uses a system method freeMemory() that returns the amount of
	 * memory currently free. We force a garbage collection via System.gc() to
	 * make the figure more reliable.
	 */

	static final int N = 25000;

	static long freemem() {
		// System.gc();
		return Runtime.getRuntime().freeMemory();
	}

	static void test01() {
		long start_mem = freemem();
		int vec[] = new int[N];
		for (int i = 0; i < N; i++)
			vec[i] = i;
		long end_mem = freemem();
		long n = (start_mem - end_mem) / N;

		System.out.println("********* test01 *********");
		System.out.println("bytes per element of primitive = " + n);
	}

	static void test02() {
		long start_mem = freemem();
		Integer vec[] = new Integer[N];
		for (int i = 0; i < N; i++)
			vec[i] = new Integer(i);
		long end_mem = freemem();
		long n = (start_mem - end_mem) / N;

		System.out.println();
		System.out.println("********* test02 *********");
		System.out.println("bytes per element of wrappers= " + n);
	}

	// test for wrappers automatically turn into primitive type
	// @link: http://macemers.iteye.com/blog/860631

	static void test03() {
		Integer a = 100;
		Integer b = 100;
		
		Integer c = 200;
		Integer d = 200;

		System.out.println();
		System.out.println();
		System.out.println("********* test03 *********");
		System.out.println(a == b); // 1
		System.out.println(a == 100); // 2

		System.out.println(c == d); // 3
		System.out.println(c == 200); // 4
	}

	static void test04() {
		Integer m = new Integer(5);
		Integer n = new Integer(5);
		System.out.println();
		System.out.println("********* test04 *********");
		System.out.println(m == n);
		m = m - 1;
		n = n - 1;
		System.out.println(m == n);
	}

	static void test05() {
		Integer i = new Integer(0);
		Integer j = new Integer(0);

		System.out.println();
		System.out.println("********* test04 *********");
		if (i <= j && i >= j && i != j)
			System.out.println("0000");
	}

	public static void main(String args[]) {
		test01();
		test02();
		test03();
		test04();
		test05();
	}

}