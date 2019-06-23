/**
 * FileName: jvm.study
 * Author    王磊
 * Date      2019/6/23 22:44
 * Description: DynamicSubject
 */
package jvm.study.bytecode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DynamicSubject
 *
 * @author Administrator
 * @since 1.0.0
 */
public class DynamicSubject implements InvocationHandler {
    private Object obj;

    public DynamicSubject(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin invoke" + method);

        method.invoke(obj, args);

        System.out.println("end invoke" + method);

        return null;
    }
}
