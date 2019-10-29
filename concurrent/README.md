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
