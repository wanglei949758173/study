package study.chapter5;

/**
 * 测试线程的优先级
 * @author Administrator
 *
 */
public class T2_Priority {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("t1 index:" + i);
			}
		}, "t1");
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("t2 index:" + i);
			}
		}, "t2");
		
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("t3 index:" + i);
			}
		}, "t3");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
