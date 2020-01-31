/**
 * FileName: test.pattern.visitor
 * Author    王磊
 * Date      2019/5/7 21:51
 * Description: 被访问的元素的接口
 */
package test.pattern.visitor;

/**
 * 被访问的元素的接口
 *
 * @author Administrator
 * @since 1.0.0
 */
public abstract class Element {
    /**
     * 接受访问者的访问
     *
     * @param visitor 访问者对象
     */
    public abstract void accept(Visitor visitor);
}
