package study.chapter5;

import java.util.concurrent.TimeUnit;

/**
 * 测试Join函数的作用
 * @author Administrator
 *
 */
public class T3_Join1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("t1 beginning");
			
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("t1 is done");
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("t2 beginning");
			
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("t2 is done");
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("main is done");
	}
}
