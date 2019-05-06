/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/6 20:45
 * Description: 打印出JVM三个类加载器加载的类的路径
 */
package jvm.study.classloader;

/**
 * 打印出JVM三个类加载器加载的类的路径
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        // 我们所写的代码会被ide自动设置到classpath中
        System.out.println(System.getProperty("java.class.path"));
    }
}
