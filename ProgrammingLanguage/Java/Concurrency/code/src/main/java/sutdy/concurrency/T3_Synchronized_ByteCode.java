package sutdy.concurrency;

/**
 * Synchronized字节码分析
 * 
 * @author Administrator
 *
 */
public class T3_Synchronized_ByteCode {
	public void test() {
		synchronized (lock) {
			System.out.println("Hello World");
		}
	}
	
	public Object lock = new Object();
	public void test2() {
		synchronized (lock) {
			System.out.println("Hello World");
			throw new RuntimeException();
		}
	}
	
	public synchronized void test3() {
		System.out.println("Hello World");
	}
	
	public static synchronized void test4() {
		System.out.println("Hello World");
	}
}
