/**
 * FileName: jvm.study.gc
 * Author    王磊
 * Date      2019/10/20 12:57
 * Description: -XX:MaxTenuringThreshold=xx
 */
package jvm.study.gc;

/**
 * -XX:MaxTenuringThreshold=xx
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest3 {
    public static void main(String[] args) {
        /*
            -verbose:gc
            -Xms20M
            -Xmx20M
            -Xmn10M
            -XX:+PrintGCDetails
            -XX:+PrintCommandLineFlags
            -XX:SurvivorRatio=8
            -XX:MaxTenuringThreshold=5
            -XX:+PrintTenuringDistribution // 打印存活对象的年龄
         */
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];

        System.out.println("Hello World");
    }
}
