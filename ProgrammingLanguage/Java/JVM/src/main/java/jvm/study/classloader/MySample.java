/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/6 20:05
 * Description: MySample
 */
package jvm.study.classloader;

/**
 * MySample
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());

        new MyCat();
    }
}
