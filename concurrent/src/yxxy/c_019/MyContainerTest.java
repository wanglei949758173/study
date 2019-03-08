/**      
 * 模块编号  
 * 功能描述 
 * 文件名 MyContainerTest.java  
 * 作者 王磊 
 * 编写日期 2018年7月11日    
 */
package yxxy.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyContainerTest {
	// 集合
	private volatile List<Object> list = new ArrayList<>();

	/**
	 * 添加
	 * @param o
	 */
	public void add(Object o) {
		list.add(o);
	}

	/**
	 * 获取集合大小
	 * @return
	 */
	public int getSize() {
		return list.size();
	}
	
	public static void main(String[] args) {
		MyContainerTest myList = new MyContainerTest();
		
		CountDownLatch latch = new CountDownLatch(1);
		
		// t2
		new Thread(() -> {
			System.out.println("t2启动...");
			if (myList.getSize() != 5) {
				try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("t2停止..");
		}, "t2" ).start();
		
		//t1
		new Thread(() -> {
			System.out.println("t1启动...");
			for (int i = 0; i < 10; i++) {
				myList.add(new Object());
				System.out.println("t1 add" + (i + 1));
				if (myList.getSize() == 5) {
					latch.countDown();
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("t1停止..");
		}, "t1" ).start();;
	}

}
