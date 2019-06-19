/**
 * FileName: jvm.study.bytecode
 * Author    王磊
 * Date      2019/6/18 22:12
 * Description: 测试对异常字节码的分析
 */
package jvm.study.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * 测试对异常字节码的分析
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyTest3 {
    public void test() throws IOException, NullPointerException {
        try {
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }
    }
}
