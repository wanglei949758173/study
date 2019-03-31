/**
 * FileName: Singleton3
 * Author:   王磊
 * Date:     2019/3/31 21:26
 * Description: 单例模式 双重检查
 */
package test.pattern.singleton;

/**
 * 单例模式 双重检查
 *
 * @author wl
 * @since 1.0.0
 */
public class Singleton3 {
    private static volatile Singleton3 instance = null;

    private Singleton3(){}

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }

        // 已创建，直接返回
        return instance;
    }
}
