/**
 * FileName: ConcreteCreator
 * Author:   王磊
 * Date:     2019/3/20 21:54
 * Description: 具体的创建器实现对象
 */
package test.pattern.factorymethod;

/**
 * 具体的创建器实现对象
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteCreator extends Creator {

    @Override
    protected Product factoryMethod() {
        return new ConcreteProduct();
    }
}
