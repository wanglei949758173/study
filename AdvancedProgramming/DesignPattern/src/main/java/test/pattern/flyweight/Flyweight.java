/**
 * FileName: Flyweight
 * Author:   王磊
 * Date:     2019/4/15 22:36
 * Description: 享元接口，通过这个接口享元可以接受并作用于外部状态
 */
package test.pattern.flyweight;

/**
 * 享元接口，通过这个接口享元可以接受并作用于外部状态
 *
 * @author wl
 * @since 1.0.0
 */
public interface Flyweight {
    /**
     * 示例操作，传入外部状态
     *
     * @param extrinsicState 示例参数，外部状态
     */
    public void operation(String extrinsicState);
}
