/**
 * FileName: test.pattern.visitor
 * Author    王磊
 * Date      2019/5/7 21:57
 * Description: 客户端
 */
package test.pattern.visitor;

/**
 * 客户端
 *
 * @author Administrator
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        //创建ObjectStructure
        ObjectStructure os = new ObjectStructure();
        //创建要加入对象结构的元素
        Element eleA = new ConcreteElementA();
        Element eleB = new ConcreteElementB();
        //把元素加入对象结构
        os.addElement(eleA);
        os.addElement(eleB);

        //创建访问者
        Visitor visitor = new ConcreteVisitor2();

        //调用业务处理的方法
        os.handleRequest(visitor);
    }
}
