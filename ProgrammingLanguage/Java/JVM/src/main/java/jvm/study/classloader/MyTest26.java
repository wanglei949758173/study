/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/19 11:30
 * Description: 线程上下文类加载器的一般使用模式
 */
package jvm.study.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest26 {
    /*
        线程上下文类加载器的一般使用模式(获取 - 使用 - 还原)

        ClassLoader targetTccl = null; // new MyClassLoader();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try {
            Thread.currentThread().setContextClassLoader(targetTccl);
            myMethod();
        } finally {
            Thread.currentThread().setContextClassLoader(classLoader);
        }

        myMethod里面则调用了Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器做某些事情。

        如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的 (如果该依赖类之前没有被加载过的话)

        ContextClassLoader的作用是为了破坏Java的类加载委托机制。

        当高层提供了统一的接口让低层去实现，同时又要在高层加载 (或实例化) 低层的类时，就必须要通过线程上下文类加载器来
        帮助高层的ClassLoader找到并加载该类。
     */
    public static void main(String[] args) {

        /*
            ServiceLoader主要用于加载 META-INF/services/ 目录下的文件名(如:java.sql.Driver)所对应的的服务实现者
            (实现者位于文件中,如java.sql.Driver文件中的com.mysql.jdbc.Driver)
         */
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver: " + driver.getClass() + ",loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器: " + Thread.currentThread().getContextClassLoader()); // APPClassLoader

        System.out.println("serviceLoader的类加载器: " + ServiceLoader.class.getClassLoader()); // null BootstrapClassLoader

    }
}
