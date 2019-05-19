/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/19 11:38
 * Description: 测试上下文类加载器
 */
package jvm.study.classloader;

/**
 * 测试上下文类加载器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest25 implements Runnable {
    private Thread thread;

    public MyTest25(){
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        System.out.println("Class: " + classLoader.getClass()); // APPClassLoader
        System.out.println("Parent: " + classLoader.getParent().getClass()); // ExtClassLoader
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
