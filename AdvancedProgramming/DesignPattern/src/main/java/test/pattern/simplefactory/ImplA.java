/**
 * FileName: ImplA
 * Author:   王磊
 * Date:     2019/3/19 20:19
 * Description: 接口的具体实现对象A
 */
package test.pattern.simplefactory;

/**
 * 接口的具体实现对象A 
 *
 * @author wl
 * @since 1.0.0
 */
public class ImplA implements Api{

    @Override
    public void operation(String s) {
        System.out.println("ImplA s=="+s);
    }
}
