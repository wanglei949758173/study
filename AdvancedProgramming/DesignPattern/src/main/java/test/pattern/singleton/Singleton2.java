/**
 * FileName: Singleton2
 * Author:   王磊
 * Date:     2019/3/31 21:21
 * Description: 单例模式 饿汉式
 */
package test.pattern.singleton;

/**
 * 单例模式 饿汉式
 *
 * @author wl
 * @since 1.0.0
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance() {
        return instance;
    }
}
