/**
 * FileName: jvm.study.gc
 * Author    王磊
 * Date      2019/10/17 21:57
 * Description: 不同GC参数的分析
 */
package jvm.study.gc;

import java.util.concurrent.TimeUnit;

/**
 * 不同GC参数的分析
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest2 {
    public static void main(String[] args) throws InterruptedException {
        /*
            1. 添加JVM启动参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
                -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=5242880(5m)
            2. 创建一个6M的对象，发现对象依然在年轻代
            3. 添加参数 -XX:+UserSerialGC 发现对象直接在老年代分配
            4. 创建一个10M的对象，OOM
            5. 创建一个4M的对象，使用jvisualvm 和jmc观察eden区变化和控制台的垃圾回收日志
         */
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[4 * size];

        TimeUnit.MINUTES.sleep(30);

        System.out.println("Hello World");
    }
}
