/**
 * FileName: ConcreteImplementorA
 * Author:   王磊
 * Date:     2019/4/3 21:58
 * Description: 真正的具体实现对象
 */
package test.pattern.bridge;

/**
 * 真正的具体实现对象
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteImplementorA implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("A");
    }
}
