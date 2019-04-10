/**
 * FileName: BModuleImpl
 * Author:   王磊
 * Date:     2019/4/10 22:02
 * Description: B模块实现
 */
package test.pattern.facade;

/**
 * B模块实现
 *
 * @author wl
 * @since 1.0.0
 */
public class BModuleImpl implements BModuleApi {

    @Override
    public void testB() {
        System.out.println("B模块实现");
    }
}
