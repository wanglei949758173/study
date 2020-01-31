/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/4 13:11
 * Description: 数组的类加载器是对应的元素的类加载器
 */
package jvm.study.classloader;

/**
 * 数组的类加载器是对应的元素的类加载器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader()); // null BootstrapClassLoader

        System.out.println("--------------------");

        MyChild5[] myChild5s = new MyChild5[2];
        System.out.println(myChild5s.getClass().getClassLoader()); // AppClassLoader

        System.out.println("---------------------");

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader()); // null
    }
}
