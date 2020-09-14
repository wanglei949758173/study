/**
 * FileName: study.datastructures.list.queue
 * Author    王磊
 * Date      2019/7/27 22:05
 * Description: 环形队列
 */
package study.datastructures.list.queue;

import java.util.Scanner;

/**
 * 环形队列
 *
 * @author Administrator
 * @since 1.0.0
 */
public class CircularQueueDemo {
	public static void main(String[] args) {
		// 创建queue
		CircularQueue queue = new CircularQueue(3);
		Scanner scanner = new Scanner(System.in);

		try {
			while (true) {
				System.out.println(
						"请输入选项 o(offer) p(poll) pe(peek) s(show) e(exit)");
				// 接收输入
				String command = scanner.nextLine();
				switch (command) {
				case "o":
					System.out.println("请输入一个数:");
					String number = scanner.nextLine();
					if (queue.offer(Integer.valueOf(number))) {
						System.out.println("入队成功");
					} else {
						System.out.println("入队失败");
					}
					;
					break;
				case "p":
					System.out.println(queue.poll());
					break;
				case "pe":
					System.out.println(queue.peek());
					break;
				case "s":
					queue.show();
					break;
				case "e":
					return;
				default:
					System.out.println("输入有误");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}

class CircularQueue {
	/**
	 * 队头指针,指向队首元素
	 */
	private int front;

	/**
	 * 队尾指针,指向队尾元素的下一个元素
	 */
	private int tail;

	/**
	 * 队列大小
	 */
	private int queueSize;

	/**
	 * 数据
	 */
	private int[] data;

	/**
	 * 构造函数
	 *
	 * @param queueSize
	 *            队列大小
	 */
	public CircularQueue(int queueSize) {
		// 因为需要预留一个元素的位置
		this.queueSize = queueSize + 1;
		data = new int[this.queueSize];
		this.front = 0;
		this.tail = 0;
	}

	/**
	 * 判断队列是否已经满了
	 *
	 * @return 队列是否已经满了
	 */
	public boolean full() {
		return (this.tail + 1) % this.queueSize == this.front;
	}

	/**
	 * 判断队列是否为空
	 *
	 * @return 队列是否为空
	 */
	public boolean empty() {
		return this.front == this.tail;
	}

	/**
	 * 向队列中添加元素
	 *
	 * @param element
	 *            待添加的元素
	 */
	public boolean offer(int element) {
		if (full()) {
			System.out.println("队列已满");
			return false;
		} else {
			this.data[tail] = element;
			// 后移tail
			this.tail = (this.tail + 1) % this.queueSize;
			return true;
		}
	}

	/**
	 * 让元素出队
	 *
	 * @return 出队的元素
	 */
	public int poll() {
		if (empty()) {
			System.out.println("队列为空");
			return -1;
		} else {
			int retNumber = data[this.front];
			// 队头后移
			this.front = (this.front + 1) % this.queueSize;
			return retNumber;
		}
	}

	/**
	 * 查看对列中的头元素,和出队不同的是,不会删除对头的元素
	 *
	 * @return 队列中的头元素
	 */
	public int peek() {
		if (empty()) {
			System.out.println("队列为空");
			return -1;
		} else {
			return this.data[this.front];
		}
	}

	/**
	 * 显示队列所有的元素
	 */
	public void show() {
		if (empty()) {
			System.out.println("队列为空");
		} else {
			int index = this.front;
			while (true) {
				if (index == this.tail) {
					break;
				}
				System.out.printf("data[%d]=%d\n", index, this.data[index]);
				index = (index + 1) % this.queueSize;
			}
		}
	}
}
