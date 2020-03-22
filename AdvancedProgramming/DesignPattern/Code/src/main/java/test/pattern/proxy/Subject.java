/**
 * FileName: Subject
 * Author:   王磊
 * Date:     2019/4/17 22:02
 * Description: 抽象的目标接口，定义具体的目标对象和代理公用的接口
 */
package test.pattern.proxy;

/**
 * 抽象的目标接口，定义具体的目标对象和代理公用的接口
 *
 * @author wl
 * @since 1.0.0
 */
public interface Subject {
    /**
     * 示意方法：一个抽象的请求方法
     */
    public void request();
}
