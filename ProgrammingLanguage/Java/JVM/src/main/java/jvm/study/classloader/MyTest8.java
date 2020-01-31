/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 17:38
 * Description: 测试static final 变量对于初始化的影响
 */
package jvm.study.classloader;

/**
 * 测试static final 变量对于初始化的影响
 *
 * @author Administrator
 * @since 1.0.0
 */

class FinalTest {
    public static final int x = 3;

    static {
        System.out.println("Final Test static block");
    }
}

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x); // 3 不会导致FinalTest类的初始化
    }
}

