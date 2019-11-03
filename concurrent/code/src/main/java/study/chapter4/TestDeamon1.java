package study.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程随着其父线程结束而结束，即使其没有执行完
 * @author Administrator
 *
 */
public class TestDeamon1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("t1 invoking");

			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("t1 invoke finished");
		}, "t1");

		// 设置为守护线程
		t1.setDaemon(true);

		t1.start();

		TimeUnit.SECONDS.sleep(20);
		System.out.println("main invoke finished");
	}
}
