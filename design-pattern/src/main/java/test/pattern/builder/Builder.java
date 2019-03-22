/**
 * FileName: Builder
 * Author:   王磊
 * Date:     2019/3/22 22:36
 * Description: 构建器接口，定义创建一个产品对象所需的各个部件的操作
 */
package test.pattern.builder;

/**
 * 构建器接口，定义创建一个产品对象所需的各个部件的操作
 *
 * @author wl
 * @since 1.0.0
 */
public interface Builder {
    /**
     * 示意方法，构建某个部件
     */
    public void buildPart();
}
