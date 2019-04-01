/**
 * FileName: Adapter
 * Author:   王磊
 * Date:     2019/4/1 21:45
 * Description: 适配器
 */
package test.pattern.adapter;

/**
 * 适配器
 *
 * @author wl
 * @since 1.0.0
 */
public class Adapter implements Target {
    /**
     * 持有需要被适配的接口对象
     */
    private Adaptee adaptee;

    /**
     * 构造方法，传入需要被适配的对象
     * @param adaptee 需要被适配的对象
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("我新添加的处理");
        //可能转调已经实现了的方法，进行适配
        adaptee.specificRequest();
    }
}
