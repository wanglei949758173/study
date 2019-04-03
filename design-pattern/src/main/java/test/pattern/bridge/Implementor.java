/**
 * FileName: Implementor
 * Author:   王磊
 * Date:     2019/4/3 21:57
 * Description: 定义实现部分的接口，可以与抽象部分接口的方法不一样
 */
package test.pattern.bridge;

/**
 * 定义实现部分的接口，可以与抽象部分接口的方法不一样
 *
 * @author wl
 * @since 1.0.0
 */
public interface Implementor {
    /**
     * 示例方法，实现抽象部分需要的某些具体功能
     */
    public void operationImpl();
}
