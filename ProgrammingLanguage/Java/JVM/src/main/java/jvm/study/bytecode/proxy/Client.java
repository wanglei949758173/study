/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/23 22:47
 * Description: 客户端
 */
package jvm.study.bytecode.proxy;

import java.lang.reflect.Proxy;

/**
 * 客户端
 *
 * @author Administrator
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject realSubject = new RealSubject();
        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);

        Class<? extends RealSubject> clazz = realSubject.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), dynamicSubject);
        subject.request();

        System.out.println(subject.getClass()); //com.sun.proxy.$Proxy0
        System.out.println(subject.getClass().getSuperclass()); // java.lang.reflect.Proxy
    }
}
