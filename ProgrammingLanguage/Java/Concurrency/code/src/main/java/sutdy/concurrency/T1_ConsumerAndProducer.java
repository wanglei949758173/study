package sutdy.concurrency;

/**
 * 测试生产者消费者模型
 * 
 * @author Administrator
 *
 */
public class T1_ConsumerAndProducer {
	public static void main(String[] args) {
		Product product = new Product();
		// 消费逻辑
		Runnable consumerRun = () -> {
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				product.decrease();
			}
		};

		// 生产逻辑
		Runnable producerRun = () -> {
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				product.increase();
			}
		};

		// 定义生产者和消费者
		Thread consumer1 = new Thread(consumerRun);
		Thread consumer2 = new Thread(consumerRun);

		Thread producer1 = new Thread(producerRun);
		Thread producer2 = new Thread(producerRun);

		consumer1.start();
		consumer2.start();
		producer1.start();
		producer2.start();
	}
}

/**
 * 商品，共消费者和生产者消费生产使用
 * 
 * @author Administrator
 *
 */
class Product {
	private int counter;

	/**
	 * 增加counter
	 */
	public synchronized void increase() {
		// 不等于0，则等待
		while (counter != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 等于0,进行生产
		counter++;
		System.out.println(this.counter);

		// 生产完成，通知消费者消费
		notify();
	}

	/**
	 * 减少counter
	 */
	public synchronized void decrease() {
		// 小于等于0则等待
		while (counter <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 大于0，进行消费
		counter--;
		System.out.println(this.counter);

		// 消费完成，通知生产者生产
		notify();
	}
}
