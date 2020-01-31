/**
 * FileName: jvm.study.gc
 * Author    王磊
 * Date      2019/10/20 13:17
 * Description: 动态调整threshold
 */
package jvm.study.gc;

/**
 * 动态调整threshold
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        /*
            -verbose:gc
            -Xmx200M
            -Xmn50M
            -XX:TargetSurvivorRatio=60
            -XX:+PrintTenuringDistribution
            -XX:+PrintGCDetails
            -XX:+UseConcMarkSweepGC
            -XX:+UseParNewGC
            -XX:MaxTenuringThreshold=3
         */
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("11111");

        myGc();
        Thread.sleep(1000);

        System.out.println("22222");

        myGc();
        Thread.sleep(1000);

        System.out.println("33333");

        myGc();
        Thread.sleep(1000);

        System.out.println("44444");

        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("55555");

        myGc();
        Thread.sleep(1000);

        System.out.println("66666");

        System.out.println("Hello World");
    }

    private static void myGc() {
        // 创建40个1M的对象
        for (int i = 0; i < 40; i++) {
            int size = 1024 * 1024;
            byte[] byteArray = new byte[size];
        }
    }
}
