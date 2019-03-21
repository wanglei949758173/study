/**
 * FileName: Client
 * Author:   王磊
 * Date:     2019/3/21 23:01
 * Description: 客户端
 */
package test.pattern.abstractfactory;

/**
 * 客户端
 *
 * @author wl
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        //创建抽象工厂对象
        AbstractFactory af = new ConcreteFactory1();

        //通过抽象工厂来获取一系列的对象，如产品A和产品B
        af.createProductA();
        af.createProductB();
    }
}
