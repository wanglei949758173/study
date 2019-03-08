/**      
 * 模块编号  
 * 功能描述 
 * 文件名 TestCyclicBarrier.java  
 * 作者 王磊 
 * 编写日期 2018年7月19日    
 */
package yxxy.c_026;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
	public static void main(String[] args) {
		int threadNum = 4;
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		
		Random random = new Random();
		
		for (int i = 0; i < threadNum; i++) {
			new Thread(() -> {
				System.out.println("线程" + Thread.currentThread().getName() + "启动了....");
				try {
					Thread.sleep(3000 + random.nextInt(10) * 1000);
					System.out.println("线程" + Thread.currentThread().getName() + "执行完毕，等待其他线程中....");
					cyclicBarrier.await();
					System.out.println("所有线程执行完毕。");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, "t" + i).start() ;
		}
	}
}
