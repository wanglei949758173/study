/**
 * FileName: Api
 * Author:   王磊
 * Date:     2019/3/19 20:17
 * Description: 接口的定义，该接口可以通过简单工厂来创建
 */
package test.pattern.simplefactory;

/**
 * API接口
 *
 * @author wl
 * @since 1.0.0
 */
public interface Api {
    /**
     * 示意，具体的功能方法的定义
     * @param s 示意，需要的参数
     */
    public void operation(String s);
}
