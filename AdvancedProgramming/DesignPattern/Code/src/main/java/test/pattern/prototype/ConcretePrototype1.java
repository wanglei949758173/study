/**
 * FileName: ConcretePrototype1
 * Author:   王磊
 * Date:     2019/3/23 21:09
 * Description: 克隆的具体实现对象
 */
package test.pattern.prototype;

/**
 * 克隆的具体实现对象
 *
 * @author wl
 * @since 1.0.0
 */
public class ConcretePrototype1 implements Prototype {

    @Override
    public Prototype clone() {
        // 最简单的克隆，新建一个自身对象，由于没有属性，就不去复制值了
        Prototype prototype = new ConcretePrototype1();
        return prototype;
    }
}
