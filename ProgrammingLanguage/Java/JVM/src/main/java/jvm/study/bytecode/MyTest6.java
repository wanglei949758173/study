/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/20 22:43
 * Description: 动态分派
 */
package jvm.study.bytecode;

/**
 * 动态分派
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test(); // apple
        orange.test(); // orange

        apple = new Orange();
        apple.test(); // orange
    }
}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}