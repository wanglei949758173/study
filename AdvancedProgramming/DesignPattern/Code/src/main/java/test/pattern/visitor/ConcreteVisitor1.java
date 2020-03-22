/**
 * FileName: test.pattern.visitor
 * Author    王磊
 * Date      2019/5/7 21:55
 * Description: 具体的访问者实现
 */
package test.pattern.visitor;

/**
 * 具体的访问者实现
 *
 * @author Administrator
 * @since 1.0.0
 */
public class ConcreteVisitor1 implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA elementA) {
        //把去访问ConcreteElementA时，需要执行的功能实现在这里
        //可能需要访问元素已有的功能，比如：
        System.out.println("ConcreteVisitor1  ==visitConcreteElementA");
        elementA.opertionA();
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB elementB) {
        //把去访问ConcreteElementB时，需要执行的功能实现在这里
        //可能需要访问元素已有的功能，比如：
        elementB.opertionB();
    }
}
