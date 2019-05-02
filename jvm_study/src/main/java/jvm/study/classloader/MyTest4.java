/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/2 20:27
 * Description: 测试array类型的变量创建是否会导致类的初始化 --不会
 */
package jvm.study.classloader;

/**
 * 测试array类型的变量创建是否会导致类的初始化 --不会
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest4 {
    public static void main(String[] args) {
        /**
         * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lxx.xx.xx.xx这种形式。
         * 动态生成的类型，其父类就是Object
         *
         * 对于数组来说，JavaDoc经常讲构成数组的元素称为Component，实际上是将数组降低一个维度后的类型。
         *
         * 助记符：
         *  anewarray:表示创建一个引用类型的(如类、接口、数组)数组，并将其引用值压入栈顶
         *  newarray:表示创建一个指定的原始类型(如int、float、char等)的数组，并将其引用值压入栈顶
         */
        MyParent4 myParent4 = new MyParent4(); // 静态代码执行

        MyParent4[] myParent4s = new MyParent4[1]; // 静态代码块不执行
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4.getClass().getSuperclass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1]; // 静态代码块不执行
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("====================");
        int[] ints = new int[1];
        System.out.println(ints.getClass());



    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
