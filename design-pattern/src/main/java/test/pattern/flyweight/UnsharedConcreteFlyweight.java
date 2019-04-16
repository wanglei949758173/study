/**
 * FileName: UnsharedConcreteFlyweight
 * Author:   王磊
 * Date:     2019/4/15 22:38
 * Description: 不需要共享的Flyweight对象，
 */
package test.pattern.flyweight;

/**
 * 不需要共享的Flyweight对象，
 * 通常是将被共享的享元对象作为子节点，组合出来的对象
 * (例如：张三拥有对用户的查询权限,则将对用户查询权限这个共享的享元对象作为子节点，组合)
 *
 * @author wl
 * @since 1.0.0
 */
public class UnsharedConcreteFlyweight implements Flyweight {

    /**
     * 示例，描述对象的状态
     */
    private String allState;

    @Override
    public void operation(String extrinsicState) {
        // 具体的功能处理
    }
}
