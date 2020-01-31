package sutdy.concurrency;

public class T4_DeadLock {
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void method1() {
		// 先获取lock1，再获取lock2
		synchronized (lock1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			synchronized (lock2) {
				System.out.println("method1");
			}
		}
	}

	public void method2() {
		// 先获取lock2，再获取lock1
		synchronized (lock2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			synchronized (lock1) {
				System.out.println("method2");
			}
		}
	}

	public static void main(String[] args) {
		T4_DeadLock deadLock = new T4_DeadLock();
		new Thread(deadLock::method1, "t1").start();
		new Thread(deadLock::method2, "t2").start();
	}
}
