/**
 * FileName: Component
 * Author:   王磊
 * Date:     2019/4/8 20:56
 * Description: 组件对象的接口，可以给这些对象动态的添加职责
 */
package test.pattern.decorator;

/**
 * 组件对象的接口，可以给这些对象动态的添加职责
 *
 * @author wl
 * @since 1.0.0
 */
public abstract class Component {
    /**
     * 示例方法
     */
    public abstract void operation();
}
