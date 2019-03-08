/**
 * 
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 * 
 * t1、t2线程开始运行时，会分别持有lock1和lock2而请求lock2和lock1，这样就发生了死锁。
 * 但是，在③处给t2线程状态标记为中断后，持有重入锁lock2的线程t2会响应中断，并不再继续等待lock1，
 * 同时释放了其原本持有的lock2，这样t1获取到了lock2，正常执行完成。
 * t2也会退出，但只是释放了资源并没有完成工作。

 * 
 * @author wanglei
 */
package yxxy.c_020;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock4 implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public ReentrantLock4(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
            	// 获取lock1的锁
                lock1.lockInterruptibly();  // 以可以响应中断的方式加锁
                System.out.println(Thread.currentThread().getName() + "获取到锁lock1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                System.out.println(Thread.currentThread().getName() + "获取到锁lock2");
            } else {
            	System.out.println(Thread.currentThread().getName() + "获取到锁lock2");
                lock2.lockInterruptibly();  // 以可以响应中断的方式加锁
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "获取到锁lock1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) lock1.unlock();  // 注意判断方式
            if (lock2.isHeldByCurrentThread()) lock2.unlock();
            System.err.println(Thread.currentThread().getName() + "退出！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	ReentrantLock4 deadLock1 = new ReentrantLock4(1);
    	ReentrantLock4 deadLock2 = new ReentrantLock4(2);
        Thread t1 = new Thread(deadLock1, "t1");
        Thread t2 = new Thread(deadLock2, "t2");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt(); // ③
    }
}
