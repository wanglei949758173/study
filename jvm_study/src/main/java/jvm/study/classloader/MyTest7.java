/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 17:14
 * Description: 测试双亲委托机制
 */
package jvm.study.classloader;

/**
 * 测试双亲委托机制
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest7 {
    public static void main(String[] args) throws Exception {
        Class<?> class1 = Class.forName("java.lang.String");
        System.out.println(class1.getClassLoader()); // null 由BootstrapClassLoader加载

        Class<?> class2 = Class.forName("jvm.study.classloader.C");
        System.out.println(class2.getClassLoader());// sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}

class C {

}
