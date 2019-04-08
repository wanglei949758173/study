/**
 * FileName: ConcreteComponent
 * Author:   王磊
 * Date:     2019/4/8 20:57
 * Description: 具体实现组件对象接口的对象
 */
package test.pattern.decorator;

/**
 * 具体实现组件对象接口的对象
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent");
    }
}
