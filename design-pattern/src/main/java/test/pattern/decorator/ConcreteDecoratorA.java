/**
 * FileName: ConcreteDecoratorA
 * Author:   王磊
 * Date:     2019/4/8 20:59
 * Description: 装饰器的具体实现对象，向组件对象添加职责
 */
package test.pattern.decorator;

/**
 * 装饰器的具体实现对象，向组件对象添加职责
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    /**
     * 添加的状态
     */
    private String addedState;

    public String getAddedState() {
        return addedState;
    }

    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }

    public void operation() {
        //调用父类的方法，可以在调用前后执行一些附加动作
        //在这里进行处理的时候，可以使用添加的状态
        System.out.println("begin---------->");
        super.operation();
        System.out.println("begin---------->");
    }

}
