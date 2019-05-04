/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/4 12:53
 * Description: 类加载器的测试
 */
package jvm.study.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 类加载器的测试
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "jvm/study/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("-----------------");


    }
}
