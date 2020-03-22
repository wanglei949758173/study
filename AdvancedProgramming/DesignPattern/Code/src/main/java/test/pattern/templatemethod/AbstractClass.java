/**
 * FileName: test.pattern.templatemethod
 * Author    王磊
 * Date      2019/4/27 21:14
 * Description: 定义模板方法、原语操作等的抽象类
 */
package test.pattern.templatemethod;

/**
 * 定义模板方法、原语操作等的抽象类
 *
 * @author Administrator
 * @since 1.0.0
 */
public abstract class AbstractClass {
    /**
     * 原语操作1，所谓原语操作就是抽象的操作，必须要由子类提供实现
     */
    public abstract void doPrimitiveOperation1();

    /**
     * 原语操作2
     */
    public abstract void doPrimitiveOperation2();

    /**
     * 模板方法，定义算法骨架
     */
    public final void templateMethod() {
        //1
        doPrimitiveOperation1();
        //2
        doPrimitiveOperation2();

    }
}
