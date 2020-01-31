/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/19 22:31
 * Description: 静态分派
 */
package jvm.study.bytecode;

/**
 * 静态分派
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest5 {
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa father = new Father();
        Grandpa son = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(father); // grandpa
        myTest5.test(son); // grandpa
    }
}

class Grandpa {
}

class Father extends Grandpa {
}

class Son extends Father {
}
