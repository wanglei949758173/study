/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/3 17:52
 * Description: 类加载不会导致类初始化，只有反射才会导致类初始化
 */
package jvm.study.classloader;

/**
 * 类加载不会导致类初始化，只有反射才会导致类初始化
 *
 * @author Administrator
 * @since 1.0.0
 */
class CL {
    static {
        System.out.println("CL static block");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("jvm.study.classloader.CL");

        System.out.println(clazz);

        System.out.println("---------------------");

        clazz = Class.forName("jvm.study.classloader.CL");

        System.out.println(clazz);

        /*
            clazz
            -------------
            CL static block
            clazz
         */
    }
}
