/**
 * FileName: ConcreteDecoratorB
 * Author:   王磊
 * Date:     2019/4/8 21:00
 * Description: 装饰器的具体实现对象，向组件对象添加职责
 */
package test.pattern.decorator;

/**
 * 装饰器的具体实现对象，向组件对象添加职责
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteDecoratorB extends Decorator {

    /**
     * 构造方法，传入组件对象
     *
     * @param component 组件对象
     */
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    /**
     * 需要添加的职责
     */
    private void addedBehavior() {
        //需要添加的职责实现
    }

    public void operation() {
        //调用父类的方法，可以在调用前后执行一些附加动作
        super.operation();
        addedBehavior();
    }
}
