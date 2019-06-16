/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/16 17:54
 * Description:
 */
package jvm.study.bytecode;

/**
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest2 {
    String str = "Welcome";

    private int x = 5;

    public static Integer i = 10;

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        myTest2.setX(8);

        i = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private Object lock = new Object();

    private void test() {
        synchronized (lock) {
            System.out.println("Hello World");
        }
    }

    private void test2() {
        synchronized (MyTest2.class) {
            System.out.println("Hello World");
        }
    }
}
