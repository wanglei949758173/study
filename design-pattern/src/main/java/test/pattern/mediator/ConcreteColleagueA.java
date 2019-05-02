/**
 * FileName: test.pattern.mediator
 * Author    王磊
 * Date      2019/5/2 21:20
 * Description: 具体的同事类A
 */
package test.pattern.mediator;

/**
 * 具体的同事类A
 *
 * @author Administrator
 * @since 1.0.0
 */
public class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    /**
     * 示意方法，执行某些业务功能
     */
    public void someOperation() {
        //在需要跟其他同事通信的时候，通知中介者对象
        getMediator().changed(this);
    }
}
