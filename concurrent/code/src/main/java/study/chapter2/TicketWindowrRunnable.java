package study.chapter2;

/**
 * 售票窗口
 * 
 * @author Administrator
 *
 */
public class TicketWindowrRunnable implements Runnable {
	/**
	 * 当前号码
	 */
	private int index = 1;

	/**
	 * 最大号码
	 */
	private static final int MAX = 50;

	@Override
	public synchronized void run() {
		while (this.index <= MAX) {
			System.out.println(Thread.currentThread().getName() + "叫号：" + index);
			index++;

			// 100ms用来处理事情
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
