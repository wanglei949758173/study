/**
 * FileName: CModuleImpl
 * Author:   王磊
 * Date:     2019/4/10 22:02
 * Description: C模块实现
 */
package test.pattern.facade;

/**
 * C模块实现
 *
 * @author wl
 * @since 1.0.0
 */
public class CModuleImpl implements CModuleApi {

    @Override
    public void testC() {
        System.out.println("C模块实现");
    }
}
