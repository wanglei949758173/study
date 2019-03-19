/**
 * FileName: Impl2
 * Author:   王磊
 * Date:     2019/3/19 20:20
 * Description: 接口的具体实现对象B
 */
package test.pattern.simplefactory;

/**
 * 接口的具体实现对象B 
 *
 * @author wl
 * @since 1.0.0
 */
public class ImplB implements Api {

    @Override
    public void operation(String s) {
        System.out.println("ImplB s=="+s);
    }
}
