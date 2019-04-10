/**
 * FileName: AModuleImpl
 * Author:   王磊
 * Date:     2019/4/10 22:01
 * Description: A模块实现
 */
package test.pattern.facade;

/**
 * A模块实现
 *
 * @author wl
 * @since 1.0.0
 */
public class AModuleImpl implements AModuleApi {

    @Override
    public void testA() {
        System.out.println("A模块实现");
    }
}
