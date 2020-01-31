package sutdy.concurrency;

/**
 * 测试Synchronized关键字的相关概念
 * 
 * @author Administrator
 *
 */
public class T2_Synchronized {
	public static void main(String[] args) throws InterruptedException {
		TaskDemo task = new TaskDemo();
		Thread t1 = new Thread(task::task1);
		Thread t2 = new Thread(task::task2);
		Thread t3 = new Thread(TaskDemo::task3);
		
		// 启动t1
		t1.start();
		Thread.sleep(200);
		// 启动t2
		t2.start();
		// 输出：task1.... task2....
		Thread.sleep(200);
		t3.start();
		// 输出:task3.... task1.... task2....
	}
}

class TaskDemo {
	public synchronized void task1() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task1....");
	}
	
	public synchronized void task2() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("task2.....");
	}
	
	public static void task3() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("task3.....");
	}
}
