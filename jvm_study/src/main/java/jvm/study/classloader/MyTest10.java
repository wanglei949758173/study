/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 17:44
 * Description: 只生命而未实例化的类是不初始化的
 */
package jvm.study.classloader;

/**
 * 只声明而未实例化的类是不初始化的
 *
 * @author Administrator
 * @since 1.0.0
 */

class Parent2 {
    static int a = 3;

    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {
    static int b = 4;

    static {
        System.out.println("Child2 static block");
    }
}
public class MyTest10 {
    static  {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent2;

        System.out.println("----------------");

        parent2 = new Parent2();

        System.out.println("-------------");

        System.out.println(parent2.a);

        System.out.println("---------------");

        System.out.println(Child2.b);

        /*
            MyTest10

            Parent2
            3

            Child2
            4
         */
    }
}
