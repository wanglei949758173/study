/**
 * FileName: Facade
 * Author:   王磊
 * Date:     2019/4/10 22:03
 * Description: 外观对象
 */
package test.pattern.facade;

/**
 * 外观对象
 *
 * @author wl
 * @since 1.0.0
 */
public class Facade {
    public void test() {
        //在内部实现的时候，可能会调用到内部的多个模块
        AModuleApi a = new AModuleImpl();
        a.testA();
        BModuleApi b = new BModuleImpl();
        b.testB();
        CModuleApi c = new CModuleImpl();
        c.testC();
    }
}
