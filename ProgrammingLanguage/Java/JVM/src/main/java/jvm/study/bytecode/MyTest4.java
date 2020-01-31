/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/19 22:15
 * Description: 局部变量表slot的说明
 */
package jvm.study.bytecode;

/**
 * 局部变量表slot的说明
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest4 {
    public void test() {
        int a = 2;
        float b = 3.0f;

        if (a < b) {
            int c = 1;
            int d = 4;
        }
        int e = 3;
        int f = 6;
    }
}
