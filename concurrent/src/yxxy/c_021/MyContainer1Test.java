/**      
 * 模块编号  
 * 功能描述 
 * 文件名 MyContainer1Test.java  
 * 作者 王磊 
 * 编写日期 2018年7月12日    
 */
package yxxy.c_021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class MyContainer1Test {
	private LinkedList<String> list = new LinkedList<>();

	final static int MAX_COUNT = 10;

	private int count = 0;

	public synchronized void put(String o) {
		while (list.size() == MAX_COUNT) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(o);
		count++;
		System.out.println("put了一个元素" + o);
		this.notifyAll();
	}
	
	public synchronized String get() {
		while (list.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String o = list.removeFirst();
		count--;
		this.notifyAll();
		System.out.println("get了一个元素" + o);
		return o;
	}
	
	public int getCount() {
		return this.count;
	}
	
	
	public static void main(String[] args) {
		MyContainer1Test container = new MyContainer1Test();
		
		// 启动3个消费者
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int j = 0; j < 5; j++) {
					container.get();
				}
			}, "consumer" + i) .start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//启动2个生产者
		for (int i = 0; i < 2; i++) {
			new Thread(() -> {
				for (int j = 0; j < 25; j++) {
					container.put(Thread.currentThread().getName() + " " + j);
				}
			}, "producer" + i) .start();
		}
	}

}
