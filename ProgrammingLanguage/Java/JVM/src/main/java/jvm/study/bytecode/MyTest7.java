/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/22 11:36
 * Description: 虚方法表
 */
package jvm.study.bytecode;

import java.util.Date;

/**
 * 虚方法表
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest7 {
    /*
        针对于方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构(virtual method table,vtable)
            子类继承父类如果没有重写父类的方法时，子类中不会copy父类的方法，而是在调用时指向父类的方法
            子类中方法描述信息对应在常量池中的索引与父类是相同的，这样可以加快在父类中检索方法的效率
        针对于invokeinterface指令来说，虚拟机会建立一个叫做接口方法表的数据结构(interface method table，itable)
     */
    public static void main(String[] args) {
        Animal animal = new Animal();
        //animal.test(null); 编译报错
        animal.test("hello");

        Dog dog = new Dog();
        dog.test(new Date());
        dog.test3();
    }
}

class Animal {
    public void test(String str) {
        System.out.println("Animal str");
    }

    public void test(Date date) {
        System.out.println("Animal date");
    }
}

class Dog extends Animal {
    @Override
    public void test(Date date) {
        System.out.println("Dog date");
    }

    @Override
    public void test(String str) {
        System.out.println("Dog str");
    }

    public void test3(){
        System.out.println("test3");
    }
}
