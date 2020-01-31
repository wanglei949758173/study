/**
 * FileName: Creator
 * Author:   王磊
 * Date:     2019/3/20 21:53
 * Description: 创建器，声明工厂方法
 */
package test.pattern.factorymethod;

/**
 * 创建器，声明工厂方法
 *
 * @author wl
 * @since 1.0.0
 */
public abstract class Creator {
    /**
     * 创建Product的工厂方法
     * @return Product对象
     */
    protected abstract Product factoryMethod();

    /**
     * 示意方法，实现某些功能的方法
     */
    public void someOperation() {
        // 通常在这些方法实现中，需要调用工厂方法来获取Product对象
        Product product = factoryMethod();
    }
}
