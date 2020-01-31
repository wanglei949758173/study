/**
 * FileName: ConcreteFlyweight
 * Author:   王磊
 * Date:     2019/4/15 22:37
 * Description: 享元对象
 */
package test.pattern.flyweight;

/**
 * 享元对象(例如：权限对象(对用户的查看权限))
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteFlyweight implements Flyweight {
    /**
     * 示例，描述内部状态
     */
    private String intrinsicState;

    /**
     * 构造方法，传入享元对象的内部状态的数据
     *
     * @param state 享元对象的内部状态的数据
     */
    public ConcreteFlyweight(String state) {
        this.intrinsicState = state;
    }

    @Override
    public void operation(String extrinsicState) {
        //具体的功能处理，可能会用到享元内部、外部的状态
    }
}
