/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/4 13:46
 * Description: 自定义类加载器，加载磁盘上的类
 */
package jvm.study.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义类加载器，加载磁盘上的类
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    private static final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super(); // 将系统类加载器当做该类加载的父类加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); // 显示指定该类加载器的父类加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) {
        System.out.println("findClass invoked!");
        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length);

    }

    private byte[] loadClassData(String className) {
        byte[] data = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "/");
        try {
            is = new FileInputStream(new File(this.path + className + fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("jvm.study.classloader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\Administrator\\Desktop\\");

        Class<?> clazz1 = loader1.loadClass("jvm.study.classloader.MyTest1");
        Object object1 = clazz1.newInstance();
        System.out.println(clazz1.hashCode());
        System.out.println(object1);

        MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("C:\\Users\\Administrator\\Desktop\\");
        Class<?> clazz2 = loader2.loadClass("jvm.study.classloader.MyTest1");
        Object object2 = clazz2.newInstance();
        System.out.println(clazz2.hashCode());
        System.out.println(object2);

    }
}
