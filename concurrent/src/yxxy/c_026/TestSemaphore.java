/**
 * 1)CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
　　　　CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
　　　　而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
　　　　另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
　　2)Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 */
package yxxy.c_026;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {
	public static void main(String[] args) {
		// 电脑数量
		int computerNum = 5;
		
		// 使用者数量
		int personNum = 8;
		
		Semaphore semaphore = new Semaphore(computerNum, true);// 公平的获得，等待时间长的先获得
		
		Random random = new Random();
		
		for (int i = 0; i < personNum; i++) {
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "上机了.....");
					TimeUnit.SECONDS.sleep(2 + random.nextInt(10));
					System.err.println(Thread.currentThread().getName() + "下机了。");
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}, "person" + i) .start();
		}
	}
}
