# 1. 线程的基本介绍
## 定义(什么是线程？)
一个进程中可以同时运行程序的最小单元。

## 线程的创建与启动
![Thread-start](/assets/Thread-start.png)
java应用启动时，JVM会默认为我们创建一个 **main线程** ，还有一些其他的守护线程。

### 两个任务并发执行的示例
```java
// 两个任务并发执行的示例
new Thread(() -> {
	for (int i = 0; i < 5; i++) {
		System.out.println("Task1 ->" + i);
		try {
			// 休眠1秒
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}).start();

new Thread(() -> {
	for (int i = 0; i < 5; i++) {
		System.out.println("Task2 ->" + i);
		try {
			// 休眠1秒
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}).start();
```

### 线程生命周期
![Thread-Lifecycle](/assets/Thread-Lifecycle.png)

### 线程的创建方式
* 继承`Thread`，重写`run()`
* 实现`Runnable`

### 线程name
创建线程对象Thread，默认有一个线程名，以Thread-开头，从0开始计数
Thread-0
Thread-1
Thread-2
Thread-3

### 不重写`Thread`的`run()`或不传递`Runnable`
在不重写`Thread`的`run()`或不传递`Runnable`时，线程执行时不进行任何调用，否则执行`run()`中的逻辑。

### ThreadGroup
如果创建线程对象时未传入ThreadGroup，Thread会默认获取父线程的ThreadGroup作为该线程的ThreadGroup，此时子线程和父线程会在同一个ThreadGroup中。

### stackSize
构造Thread的时候传入stacksize代表着该线程占用的stack大小，如果没有指定stacksize的大小，默认是0,0代表着会忽略改参数，该参数会被JNI函数去使用。
需要注意：**该参数有一些平台有效，在有些平台则无效**
* stackSize越大，其他线程可用的内存就越小，因为总的stack内存的大小是有限的。

### 守护线程
* 守护线程随着其父线程结束而结束，即使其没有执行完
```java
// 随着System.out.println("main invoke finished");执行的完毕整个程序结束，不会等到线程t1执行完成
public static void main(String[] args) throws InterruptedException {
	Thread t1 = new Thread(() -> {
		System.out.println("t1 invoking");

		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("t1 invoke finished");
	}, "t1");

	// 设置为守护线程
	t1.setDaemon(true);

	t1.start();

	TimeUnit.SECONDS.sleep(20);
	System.out.println("main invoke finished");
}
```
* 守护线程的一种应用方式
	* 长连接，可以设置维护心跳的线程为守护线程，这样可以达到连接断开，心跳线程结束的目的

### 线程API
* `getName()`
获取线程的名称

获取线程Id
* `getId()`
```java
/* Set thread ID */
tid = nextThreadID();
private static synchronized long nextThreadID() {
    return ++threadSeqNumber;
}
```
* `getPriority()`
获取线程的优先级
```
// 线程的优先级并不能绝对保证线程的执行顺序
Thread t1 = new Thread(() -> {
	for (int i = 0; i < 100; i++) {
		System.out.println("t1 index:" + i);
	}
}, "t1");

Thread t2 = new Thread(() -> {
	for (int i = 0; i < 100; i++) {
		System.out.println("t2 index:" + i);
	}
}, "t2");

Thread t3 = new Thread(() -> {
	for (int i = 0; i < 100; i++) {
		System.out.println("t3 index:" + i);
	}
}, "t3");

t1.setPriority(Thread.MIN_PRIORITY);
t2.setPriority(Thread.NORM_PRIORITY);
t3.setPriority(Thread.MAX_PRIORITY);

t1.start();
t2.start();
t3.start();
```
* `join()`
	* 在线程A中调用线程B的`join()`函数，则A会等待B执行完成再执行自己的逻辑。
		```java
		Thread t1 = new Thread(() -> {
			System.out.println("t1 beginning");

			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("t1 is done");
		});
		t1.start();
		t1.join();

		System.out.println("main is done");
		```
	* 在线程A中调用线程B的`join()`函数和线程C的`join()`函数，则线程A会等待A和B都执行完成再执行，但B和C可以交替执行。
		```java
		Thread t1 = new Thread(() -> {
			System.out.println("t1 beginning");

			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("t1 is done");
		});

		Thread t2 = new Thread(() -> {
			System.out.println("t2 beginning");

			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("t2 is done");
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println("main is done");
		```
	* 示例：等待所有线程结束后再记录结束时间
		```java
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
		```
	* `interrupt`
	sleep wait join
