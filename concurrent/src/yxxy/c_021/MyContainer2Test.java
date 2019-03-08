/**      
 * 模块编号  
 * 功能描述 
 * 文件名 MyContainer2Test.java  
 * 作者 王磊 
 * 编写日期 2018年7月12日    
 */
package yxxy.c_021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2Test {
	private LinkedList<String> list = new LinkedList<>();

	private final int MAX_COUNT = 10;

	private int count = 0;

	public int getCount() {
		return count;
	}

	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();

	public void put(String o) {
		try {
			lock.lock();
			while (list.size() == MAX_COUNT) {
				producer.await();
			}
			list.add(o);
			count++;
			System.out.println("put了一个元素" + o);
			consumer.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
	
	public String get() {
		String o = null;
		try {
			lock.lock();
			while (list.size() == 0) {
				consumer.await();
			}
			o = list.removeFirst();
			count--;
			System.out.println("get了一个元素" + o);
			producer.signalAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return o;
	}
	
	public static void main(String[] args) {
		MyContainer2Test container = new MyContainer2Test();
		
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
