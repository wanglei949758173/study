/**
 * FileName: test.pattern.observer
 * Author    王磊
 * Date      DATE 19:54
 * Description: 观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
package test.pattern.observer;

/**
 * 观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 *
 * @author Administrator
 * @since 1.0.0
 */
public interface Observer {

    /**
     * 更新的接口
     *
     * @param subject 传入目标对象，好获取相应的目标对象的状态
     */
    public void update(Subject subject);
}
