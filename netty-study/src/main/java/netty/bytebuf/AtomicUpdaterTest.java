/**
 * FileName: netty.bytebuf
 * Author    王磊
 * Date      2019/4/23 22:04
 * Description: 测试AtomicUpdater
 */
package netty.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 测试AtomicUpdater
 *
 * @author Administrator
 * @since 1.0.0
 */
public class AtomicUpdaterTest {
    public static void main(String[] args) {
        Person person = new Person();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(person.age++);
//            }).start();
//        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater =
                        AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
                System.out.println(atomicIntegerFieldUpdater.getAndIncrement(person));
            }).start();
        }


    }
}

class Person {
    volatile int age = 1;
}
