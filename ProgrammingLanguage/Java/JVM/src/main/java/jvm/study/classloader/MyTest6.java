/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 12:14
 * Description: 类的初始化
 */
package jvm.study.classloader;

/**
 * 类的初始化
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:" + Singleton.counter1); // 1
        System.out.println("counter2:" + Singleton.counter2); // 0
    }
}


class Singleton {
    public static int counter1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++; // 准备阶段的重要意义

        System.out.println(counter1); // 1
        System.out.println(counter2); // 1
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
