/**
 * FileName: test.pattern.visitor
 * Author    王磊
 * Date      2019/5/7 21:53
 * Description: 具体元素的实现对象
 */
package test.pattern.visitor;

/**
 * 具体元素的实现对象
 *
 * @author Administrator
 * @since 1.0.0
 */
public class ConcreteElementB extends Element {
    @Override
    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitConcreteElementB(this);
    }

    /**
     * 示例方法，表示元素已有的功能实现
     */
    public void opertionB() {
        //已有的功能实现
        System.out.println("ConcreteElementB 的 opertionB");
    }
}
