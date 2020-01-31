/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 12:02
 * Description: 父子接口初始化过程
 */
package jvm.study.classloader;

/**
 * 父子接口初始化过程
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest5 {
    public static void main(String[] args) {
        /*
            当一个接口在初始化时，并不要求其父接口都完成了初始化
            只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
         */
        System.out.println(MyChild5.b); // 不会导致MyParent5的初始化

        /*
            当一个类在初始化时，也不要求其父接口都完成初始化
         */
        System.out.println(MyChild5_c.c); // 不会导致MyParent5的初始化
    }
}

interface MyParent5 {
    public static final Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

interface MyChild5 extends MyParent5 {
    public static final int b = 5;
}

class MyChild5_c implements MyParent5 {
    public static int c = 10;
}
