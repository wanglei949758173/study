/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 17:49
 * Description: 子类引用父类的静态变量子类不会初始化
 */
package jvm.study.classloader;

/**
 * 子类引用父类的静态变量子类不会初始化
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);//子类不会初始化
        Child3.doSomething();

        /*
            Parent3
            3
            do something
         */
    }
}

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child3 static block");
    }
}
