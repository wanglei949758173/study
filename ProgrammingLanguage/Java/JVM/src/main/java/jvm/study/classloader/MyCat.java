/**
 * FileName: jvm.study.classloader
 * Author    王磊
 * Date      2019/5/6 20:04
 * Description: MyCat
 */
package jvm.study.classloader;

/**
 * MyCat
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
    }
}
