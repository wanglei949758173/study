/**
 * FileName: test.pattern.chainofresponsibility
 * Author    王磊
 * Date      2019/4/28 22:31
 * Description: 客户端
 */
package test.pattern.chainofresponsibility;

/**
 * 客户端
 *
 * @author Administrator
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        //先要组装职责链
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();

        h1.setSuccessor(h2);


        //然后提交请求
        h1.handleRequest();
    }
}
