package study.datastructures.list.queue;

/**
 * 测试使用数组实现队列
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
		// 使用队列
		Queue queue = new Queue(3);

		// 入队
		queue.offer(1);
		queue.offer(2);
		queue.show();

		// 出队
		System.out.println("出队");
		queue.poll();
		queue.show();

		// peek
		System.out.println("peek");
		queue.peek();
		queue.show();

		// 出队
		System.out.println("出队");
		queue.poll();
		queue.show();
	}
}

class Queue {
	/**
	 * 队列头,指向队首元素
	 */
	private int head;

	/**
	 * 队列尾,指向最后一个元素
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
	 * @param queueSize
	 *            队列大小
	 */
	public Queue(int queueSize) {
		this.queueSize = queueSize;
		data = new int[queueSize];
		this.head = 0;
		this.tail = -1;
	}

	/**
	 * 判断队列是否已经满了
	 *
	 * @return 队列是否已经满了
	 */
	public boolean isFull() {
		return this.tail == this.queueSize - 1;
	}

	/**
	 * 判断队列是否为空
	 *
	 * @return 队列是否为空
	 */
	public boolean isEmpty() {
		return this.head > this.tail;
	}

	/**
	 * 向队列中添加元素
	 *
	 * @param element
	 *            待添加的元素
	 */
	public boolean offer(int element) {
		if (isFull()) {
			return false;
		} else {
			this.tail++;
			this.data[this.tail] = element;
			return true;
		}
	}

	/**
	 * 让元素出队
	 *
	 * @return 出队的元素
	 */
	public int poll() {
		if (isEmpty()) {
			return -1;
		} else {
			int returnNumber = data[this.head];
			this.head++;
			return returnNumber;
		}
	}

	/**
	 * 查看对列中的头元素,和出队不同的是,不会删除对头的元素
	 *
	 * @return 队列中的头元素
	 */
	public int peek() {
		if (isEmpty()) {
			return -1;
		} else {
			return data[this.head];
		}
	}

	/**
	 * 显示队列所有的元素
	 */
	public void show() {
		if (isEmpty()) {
			System.out.println("队列为空");
		} else {
			for (int i = this.head; i <= this.tail; i++) {
				System.out.printf("data[%d]=%d\n", i, data[i]);
			}
		}
	}
}