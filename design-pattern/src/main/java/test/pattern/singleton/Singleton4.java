/**
 * FileName: Singleton4
 * Author:   王磊
 * Date:     2019/3/31 21:29
 * Description: 单例模式 静态内部类
 */
package test.pattern.singleton;

/**
 * 单例模式 静态内部类
 *
 * @author wl
 * @since 1.0.0
 */
public class Singleton4 {

    private Singleton4() {

    }

    private static class SingletonHolder {
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }

}
