/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/4 12:40
 * Description: 测试双亲委托机制
 */
package jvm.study.classloader;

/**
 * 测试双亲委托机制
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        // sun.misc.Launcher$AppClassLoader@18b4aac2

        while (classLoader != null) {
            classLoader = classLoader.getParent();

            System.out.println(classLoader);
        }
        /*
            sun.misc.Launcher$ExtClassLoader@1b6d3586
            null
         */
    }
}
