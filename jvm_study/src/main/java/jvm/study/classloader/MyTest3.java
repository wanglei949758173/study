/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/2 20:22
 * Description: 测试final修饰的静态变量值为UUID时类加载的过程
 */
package jvm.study.classloader;

import java.util.UUID;

/**
 * 测试final修饰的静态变量值为UUID时类加载的过程
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest3 {
    public static void main(String[] args) {
        /**
         * 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中，
         * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
         */
        System.out.println(MyParent3.str); // MyParent3静态代码块执行
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block");
    }
}