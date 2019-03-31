/**
 * FileName: Singleton1
 * Author:   王磊
 * Date:     2019/3/31 21:11
 * Description: 单例模式 懒汉式
 */
package test.pattern.singleton;

/**
 * 单例模式 懒汉式
 *
 * @author wl
 * @since 1.0.0
 */
public class Singleton1 {
    private static Singleton1 instance = null;

    /**
     * 私有化构造
     */
    private Singleton1() {
    }

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }

        return instance;
    }
}
