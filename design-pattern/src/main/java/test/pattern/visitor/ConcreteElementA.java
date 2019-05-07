/**
 * FileName: test.pattern.visitor
 * Author    王磊
 * Date      2019/5/7 21:52
 * Description: 具体元素的实现对象
 */
package test.pattern.visitor;

/**
 * 具体元素的实现对象
 *
 * @author Administrator
 * @since 1.0.0
 */
public class ConcreteElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitConcreteElementA(this);
    }

    /**
     * 示例方法，表示元素已有的功能实现
     */
    public void opertionA() {
        //已有的功能实现
        System.out.println("ConcreteElementA 的 opertionA");
    }
}
