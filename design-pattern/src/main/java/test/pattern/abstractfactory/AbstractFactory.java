/**
 * FileName: AbstractFactory
 * Author:   王磊
 * Date:     2019/3/21 22:58
 * Description: 抽象工厂的接口，声明创建抽象产品对象的操作
 */
package test.pattern.abstractfactory;

/**
 * 抽象工厂的接口，声明创建抽象产品对象的操作
 *
 * @author wl
 * @since 1.0.0
 */
public interface AbstractFactory {
    /**
     * 示例方法，创建抽象产品A的对象
     * @return 抽象产品A的对象
     */
    public AbstractProductA createProductA();

    /**
     * 示例方法，创建抽象产品B的对象
     * @return 抽象产品B的对象
     */
    public AbstractProductB createProductB();
}
