/**
 * FileName: RefinedAbstraction
 * Author:   王磊
 * Date:     2019/4/3 21:59
 * Description: 扩充由Abstraction定义的接口功能
 */
package test.pattern.bridge;

/**
 * 扩充由Abstraction定义的接口功能
 *
 * @author wl
 * @since 1.0.0
 */
public class RefinedAbstraction extends Abstraction {
    /**
     * 构造方法，传入实现部分的对象
     *
     * @param impl 实现部分的对象
     */
    public RefinedAbstraction(Implementor impl) {
        super(impl);
    }

    /**
     * 示例操作，实现一定的功能，可能会使用具体实现部分的实现方法，
     * 但是本方法更大的可能是使用Abstraction中定义的方法，
     * 通过组合使用Abstraction中定义的方法来完成更多的功能
     */
    public void otherOperation(){
        //
    }
}
