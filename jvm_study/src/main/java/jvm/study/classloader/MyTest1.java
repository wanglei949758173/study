/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/1 12:58
 * Description: 测试类的初始化
 */
package jvm.study.classloader;

/**
 * 测试类的初始化
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest1 {
    public static void main(String[] args) {
//        System.out.println(MyChild1.str); // MyChild1不初始化静态代码块不执行 MyParent1初始化，静态代码块执行

        System.out.println(MyChild1.str2); // MyChild初始化，所有的父类也都初始化
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}