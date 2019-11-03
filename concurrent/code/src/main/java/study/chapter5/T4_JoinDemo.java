package study.chapter5;

import java.util.concurrent.TimeUnit;

/**
 * Join示例-所有线程结束后记录结束时间
 * 
 * @author Administrator
 *
 */
public class T4_JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new TT("t1", 5));
		Thread t2 = new Thread(new TT("t2", 10));
		Thread t3 = new Thread(new TT("t3", 6));

		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println("所有线程全部结束");
	}
}

class TT implements Runnable {

	private String name;
	private long sleepTime;
	
	public TT(String name, long sleepTime) {
		super();
		this.name = name;
		this.sleepTime = sleepTime;
	}



	@Override
	public void run() {
		System.out.println(name + " beginning");
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " is done");
	}

}
