/**
 * FileName: jvm.study.memory
 * Author    王磊
 * Date      2019/9/28 20:46
 * Description: 测试堆内存溢出
 */
package jvm.study.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆内存溢出
 *
 * @author Administrator
 * @since 1.0.0
 */
public class TestHeapOutOfMemeory {
    public static void main(String[] args) {
        /*
            设置vm options -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
            使用jvisualvm查看dump文件
         */
        List<Object> list = new ArrayList<Object>();
        for (; ; ) {
            Object obj = new Object();
            list.add(obj);

            // 调用gc后进行监控
            System.gc();
        }
    }
}
