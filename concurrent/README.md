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
守护线程随着其父线程结束而结束，即使其没有执行完

长连接，心跳线程用守护线程，这样可以达到连接断开，心跳线程结束
