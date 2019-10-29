package study.chapter2;

/**
 * 银行
 * @author Administrator
 *
 */
public class Bank {
	public static void main(String[] args) {
		TicketWindowrRunnable runnable = new TicketWindowrRunnable();
		
		// 创建4个窗口
		Thread window1 = new Thread(runnable, "window1");
		Thread window2 = new Thread(runnable, "window2");
		Thread window3 = new Thread(runnable, "window3");
		Thread window4 = new Thread(runnable, "window4");
		
		window1.start();
		window2.start();
		window3.start();
		window4.start();
	}
}
