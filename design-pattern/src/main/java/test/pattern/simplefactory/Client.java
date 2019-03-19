/**
 * FileName: Client
 * Author:   王磊
 * Date:     2019/3/19 20:23
 * Description: 客户端，使用Api接口
 */
package test.pattern.simplefactory;

/**
 * 客户端，使用Api接口
 *
 * @author wl
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("生成A对象");
        Api apiA = Factory.createApi(1);
        apiA.operation("hello");

        System.out.println("生成B对象");
        Api apiB = Factory.createApi(2);
        apiB.operation("hello");
    }
}
