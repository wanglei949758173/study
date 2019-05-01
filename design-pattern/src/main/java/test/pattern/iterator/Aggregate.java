/**
 * FileName: test.pattern.iterator
 * Author    王磊
 * Date      2019/5/1 10:36
 * Description: 聚合对象的接口，定义创建相应迭代器对象的接口
 */
package test.pattern.iterator;

/**
 * 聚合对象的接口，定义创建相应迭代器对象的接口
 *
 * @author Administrator
 * @since 1.0.0
 */
public abstract class Aggregate {
    /**
     * 工厂方法，创建相应迭代器对象的接口
     *
     * @return 相应迭代器对象的接口
     */
    public abstract Iterator createIterator();
}
