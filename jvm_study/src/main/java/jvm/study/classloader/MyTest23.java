/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/9 20:47
 * Description: 自定义系统类加载器(应用类加载器)
 */
package jvm.study.classloader;

import sun.misc.Launcher;

/**
 * 自定义系统类加载器(应用类加载器)
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /*
            内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及他的Java平台类，
            当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，
            这块特殊的机器码叫做启动类加载器(Bootstrap ClassLoader)

            启动类加载器并不是Java类，而其他的加载器则都是Java类，
            启动类加载器是特定于平台的机器指令，它负责开启整个加载过程。

            所有类加载器（除了启动类加载器）都被实现为Java类。不过，总归要有一个组件来加载第一个Java类加载器，
            从而整个加载过程才能够被顺利进行下去，加载第一个纯Java类加载器就是启动类加载器的职责。

            启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等等。

            要将自定义的类加载器作为系统类加载器的条件
                1.设置系统属性java.system.class.loader=com.xx.xx.A
                2.自定义类加载器必须有一个构造函数为A(ClassLoader parent)，这个构造函数将被系统调用
               注意:自定义类加载器作为系统类加载器时，其父委托加载器是AppClassLoader
         */

        System.out.println(ClassLoader.class.getClassLoader()); // null 因为由启动类加载器加载

        // ExtClassloader和AppClassloader也是由BootstrapClassloader所加载的
        System.out.println(Launcher.class.getClassLoader()); // null 因为由启动类加载器加载

        System.out.println("---------------");
        System.out.println(System.getProperty("java.system.class.loader"));// null


        System.out.println(MyTest23.class.getClassLoader());// AppClassLoder
        System.out.println(MyTest16.class.getClassLoader());// AppClassLoder

        // java -Djava.system.class.loader=jvm.study.classloader.MyTest16 jvm.study.classloader.MyTest23
        System.out.println(ClassLoader.getSystemClassLoader()); // jvm.study.classloader.MyTest16
    }
}
