/**
 * FileName: jvm.study.memory
 * Author    王磊
 * Date      2019/9/28 21:09
 * Description: 测试栈内存溢出
 */
package jvm.study.memory;

/**
 * 测试栈内存溢出
 *
 * @author Administrator
 * @since 1.0.0
 */
public class TestStackOverFlow {
    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;

        /*
            睡眠300ms，使用jvisualvm 进行监视
         */
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test();
    }

    public static void main(String[] args) {
        /*
            1.设置vm options -Xss100K
            2.运行程序,观察栈溢出现象
         */

        TestStackOverFlow test = new TestStackOverFlow();
        try {
            test.test();

        } catch (Throwable throwable) {
            System.out.println(test.length);
            throwable.printStackTrace();
        }

    }
}
