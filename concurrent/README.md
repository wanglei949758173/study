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
