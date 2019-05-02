/**
 * FileName: test.pattern.mediator
 * Author    王磊
 * Date      2019/5/2 21:18
 * Description: 同事类的抽象父类
 */
package test.pattern.mediator;

/**
 * 同事类的抽象父类
 *
 * @author Administrator
 * @since 1.0.0
 */
public abstract class Colleague {
    /**
     * 持有中介者对象，每一个同事类都知道它的中介者对象
     */
    private Mediator mediator;

    /**
     * 构造方法，传入中介者对象
     *
     * @param mediator 中介者对象
     */
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 获取当前同事类对应的中介者对象
     *
     * @return 对应的中介者对象
     */
    public Mediator getMediator() {
        return mediator;
    }
}
