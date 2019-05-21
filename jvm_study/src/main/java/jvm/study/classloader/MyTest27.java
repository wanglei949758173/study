/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/21 21:57
 * Description: 上下文类加载器测试
 */
package jvm.study.classloader;

import java.sql.DriverManager;

/**
 * 上下文类加载器测试
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest27 {
    public static void main(String[] args) throws Exception {
        /*
            注册JDBC的驱动(使用ServiceLoader加载驱动)
                Class.forName加载并实例化Driver导致Driver静态代码块执行，进而导致DriverManager静态代码块执行，最终由ServiceLoader加载驱动
         */
        Class.forName("com.mysql.jdbc.Driver");

        /*
            遍历所有加载的驱动尝试连接数据库，哪一个连接成功了就返回哪一个的连接。
                使用Driver获取connection前，会判断加载Driver的类加载器和当前调用getConnection方法的类对应的类加载器是否为同一个类加载器(类加载器命名空间相同)，
                如果不是一个类加载器就会产生问题，因为不同类加载器加载同一个类，jvm会认为是不同的类。

         */
        DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
    }
}
