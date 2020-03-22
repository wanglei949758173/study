/**
 * FileName: RealSubject
 * Author:   王磊
 * Date:     2019/4/17 22:03
 * Description: 具体的目标对象，是真正被代理的对象
 */
package test.pattern.proxy;

/**
 * 具体的目标对象，是真正被代理的对象
 *
 * @author wl
 * @since 1.0.0
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("RealSubject");
    }
}
