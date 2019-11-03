package study.chapter5;
/**
 * 测试线程简单的API
 * 
 * @author Administrator
 *
 */
public class T1_SimpleAPI {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println("t1 running ...");
		});
		
		System.out.println(t1.getName());
		System.out.println(t1.getId());
		System.out.println(t1.getPriority());
	}
}
