/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/23 22:42
 * Description: RealSubject
 */
package jvm.study.bytecode.proxy;

/**
 * RealSubject
 *
 * @author Administrator
 * @since 1.0.0
 */
public class RealSubject implements Subject {

    public void request() {
        System.out.println("From Real Subject");
    }
}
