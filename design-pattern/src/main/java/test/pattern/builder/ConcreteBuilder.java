/**
 * FileName: ConcreteBuilder
 * Author:   王磊
 * Date:     2019/3/22 22:37
 * Description: 具体的构建器实现对象
 */
package test.pattern.builder;

/**
 * 具体的构建器实现对象
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteBuilder implements Builder {
    /**
     * 构建器最终构建的产品对象
     */
    private Product resultProduct;

    /**
     * 获取构建器最终构建的产品对象
     * @return 构建器最终构建的产品对象
     */
    public Product getResult() {
        return resultProduct;
    }

    @Override
    public void buildPart() {
    }
}
