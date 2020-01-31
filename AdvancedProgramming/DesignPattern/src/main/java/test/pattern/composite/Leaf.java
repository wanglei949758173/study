/**
 * FileName: Leaf
 * Author:   王磊
 * Date:     2019/4/7 22:07
 * Description: 叶子对象，叶子对象不再包含其它子对象
 */
package test.pattern.composite;

/**
 * 叶子对象，叶子对象不再包含其它子对象
 *
 * @author wl
 * @since 1.0.0
 */
public class Leaf extends Component {


    /**
     * 示意方法，叶子对象可能有自己的功能方法
     */
    @Override
    public void someOperation() {
        System.out.println("Leaf");
    }
}
