/**
 * FileName: Prototype
 * Author:   王磊
 * Date:     2019/3/23 21:08
 * Description: 声明一个克隆自身的接口
 */
package test.pattern.prototype;

/**
 * 声明一个克隆自身的接口
 *
 * @author wl
 * @since 1.0.0
 */
public interface Prototype {
    /**
     * 克隆自身的方法
     *
     * @return 一个从自身克隆出来的对象
     */
    public Prototype clone();
}
