/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/22 15:34
 * Description: 栈指令实例
 */
package jvm.study.bytecode;

/**
 * 栈指令实例
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest8 {
    public int calculate() {
        int a = 6;
        int b = 3;
        int c = 2;
        int d = 1;

        int result = (a + b - c) * d;

        return result;
    }
}
