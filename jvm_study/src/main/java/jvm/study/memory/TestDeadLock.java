/**
 * FileName: jvm.study.memory
 * Author    王磊
 * Date      2019/9/28 21:22
 * Description: 测试死锁
 */
package jvm.study.memory;

/**
 * 测试死锁
 *
 * @author Administrator
 * @since 1.0.0
 */
public class TestDeadLock {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void test1() {
        // 使用lock1
        synchronized (lock1) {
            System.out.println("test1 use lock1");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 使用lock2
            synchronized (lock2) {
                System.out.println("test1 use lock2");
            }
        }
    }

    public void test2() {
        synchronized (lock2) {
            System.out.println("test2 use lock2");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 使用lock1
            synchronized (lock1) {
                System.out.println("test2 use lock1");
            }
        }
    }

    public static void main(String[] args) {
        final TestDeadLock testDeadLock = new TestDeadLock();

        new Thread(testDeadLock::test1).start();
        new Thread(testDeadLock::test2).start();
    }
}
