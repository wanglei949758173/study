/**
 * FileName: Target
 * Author:   王磊
 * Date:     2019/4/1 21:46
 * Description: 定义客户端使用的接口，与特定领域相关
 */
package test.pattern.adapter;

/**
 * 定义客户端使用的接口，与特定领域相关
 *
 * @author wl
 * @since 1.0.0
 */
public interface Target {
    /**
     * 示意方法，客户端请求处理的方法
     */
    public void request();
}
