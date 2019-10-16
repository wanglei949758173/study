/**
 * FileName: jvm.study
 * Author    王磊
 * Date      2019/10/16 21:22
 * Description: Minor GC 和 Full GC 产生的GC日志的分析
 */
package jvm.study;

/**
 * Minor GC 和 Full GC 产生的GC日志的分析
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest {
    public static void main(String[] args) {
        /*
            1. 设置参数:
            -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8

            2. 使用7M(2 + 2 + 3)大小的空间，出现Minor GC
               分析GC日志

            3. 分配8M大小(2 + 2 + 2 + 2)出现Full GC

            4. 分配10M大小(2 + 2 + 3 + 3)未出现Full GC
         */
        int size = 1024 * 1024; // 1M

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        byte[] myAlloc4 = new byte[3 * size];

        System.out.println("Hello World");
    }
}
