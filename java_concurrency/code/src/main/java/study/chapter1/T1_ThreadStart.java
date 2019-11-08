package study.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * 测试线程的启动
 * @author Administrator
 *
 */
public class T1_ThreadStart {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 	1. 休眠5分钟，观察JVM为Application启动了什么线程，使用jconsole查看
		 */
//		TimeUnit.MINUTES.sleep(5);
		
		// 两个任务并发执行的示例
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Task1 ->" + i);
				try {
					// 休眠1秒
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Task2 ->" + i);
				try {
					// 休眠1秒
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();  

	}
}
