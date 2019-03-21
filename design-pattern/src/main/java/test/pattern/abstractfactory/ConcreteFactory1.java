/**
 * FileName: ConcreteFactory1
 * Author:   王磊
 * Date:     2019/3/21 22:59
 * Description: 具体的工厂实现对象，实现创建具体的产品对象的操作
 */
package test.pattern.abstractfactory;

/**
 * 具体的工厂实现对象，实现创建具体的产品对象的操作
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteFactory1 implements AbstractFactory {


    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
