package study.chapter3;

/**
 * 测试创建线程时指定stacksize
 * 
 * @author Administrator
 *
 */
public class TestStackSize {
	public static int counter = 0;

	public static void main(String[] args) {
		new Thread(null, () -> {
			try {
				TestStackSize.add();
			} catch (Error e) {
				e.printStackTrace();
				System.out.println(TestStackSize.counter);
			}
		}, "Test", 1 << 24).start();
	}

	public static void add() {
		counter++;
		add();
	}
}
