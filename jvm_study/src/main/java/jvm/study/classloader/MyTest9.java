/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 17:41
 * Description: 父子类初始化结论测试
 */
package jvm.study.classloader;

/**
 * 父子类初始化结论测试
 *
 * @author Administrator
 * @since 1.0.0
 */
class Parent {
    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent {
    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}

public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
        /*
            MyTest9
            Parent
            Child
            4
         */
    }
}
