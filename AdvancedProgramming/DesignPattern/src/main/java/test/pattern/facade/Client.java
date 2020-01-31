/**
 * FileName: Client
 * Author:   王磊
 * Date:     2019/4/10 22:03
 * Description: 客户端
 */
package test.pattern.facade;

/**
 * 客户端
 *
 * @author wl
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
          //不用Facade，需要自己跟多个模块交互
//        AModuleApi a = new AModuleImpl();
//        a.testA();
//        BModuleApi b = new BModuleImpl();
//        b.testB();
//        CModuleApi c = new CModuleImpl();
//        c.testC();
//
//        System.out.println("使用Facade----------------------〉");
        //使用了Facade
        new Facade().test();
    }

}
