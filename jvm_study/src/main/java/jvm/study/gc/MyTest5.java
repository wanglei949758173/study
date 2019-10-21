/**
 * FileName: jvm.study.gc
 * Author    王磊
 * Date      2019/10/21 21:36
 * Description: CMS垃圾回收的7个阶段
 */
package jvm.study.gc;

/**
 * CMS垃圾回收的7个阶段
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest5 {
    public static void main(String[] args) {
        /*
            -verbose:gc
            -Xms20M
            -Xmx20M
            -Xmn10M
            -XX:+PrintGCDetails
            -XX:SurvivorRatio=8
            -XX:+UseConcMarkSweepGC
         */
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[4 * size];
        System.out.println("111111");

        byte[] myAlloc2 = new byte[4 * size];
        System.out.println("222222");

        byte[] myAlloc3 = new byte[4 * size];
        System.out.println("333333");

        byte[] myAlloc4 = new byte[2 * size];
        System.out.println("444444");
    }
}
