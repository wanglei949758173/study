/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/6 20:10
 * Description: 测试类加载机制
 */
package jvm.study.classloader;

/**
 * 测试类加载机制
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("jvm.study.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());

        // 如果注释掉该行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会初始化MyCat类
        Object object = clazz.newInstance();
    }
}
