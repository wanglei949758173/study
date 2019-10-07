/**
 * FileName: jvm.study.memory
 * Author    王磊
 * Date      2019/10/7 15:58
 * Description: 测试元空间内存溢出
 */
package jvm.study.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 测试元空间内存溢出
 *
 * @author Administrator
 * @since 1.0.0
 */
public class TestMetaSpaceOOM {

    public static void main(String[] args) {
        /*
            1.编写使用cglib生成字节码文件的代码
            2.调整VM Options -XX:MaxMetaspaceSize=10m 观察元空间内存溢出情况
            3.调整VM Options -XX:MaxMetaspaceSize=200m
                并使用jvisualvm查看类加载个数和元空间大小的变化情况
         */
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TestMetaSpaceOOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) ->
                    proxy.invokeSuper(obj, args1));

            System.out.println("hello world");
            enhancer.create();
        }
    }
}
