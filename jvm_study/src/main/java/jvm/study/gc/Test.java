/**
 * FileName: jvm.study.gc
 * Author    王磊
 * Date      2019/10/15 22:13
 * Description: c
 */
package jvm.study.gc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * c
 *
 * @author Administrator
 * @since 1.0.0
 */
public class Test {
    String url;
    String name;
    String passwd;

    void test() {
        try {
            Connection connection = DriverManager.getConnection(url, name, passwd);
            doSomeThing();
            connection.close();

        } catch (Exception e) {
            // 如果doSomeThing抛出异常，会导致connection泄漏
        }
    }
}
