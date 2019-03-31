/**
 * FileName: OldClient
 * Author:   王磊
 * Date:     2019/3/31 16:39
 * Description: 传统IO客户端
 */
package zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 传统IO客户端
 *
 * @author wl
 * @since 1.0.0
 */
public class OldClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8899);

        String fileName = "D:\\前端\\html+css\\源码、课件\\笔记.zip";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节数：" + total + "，耗时" + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        inputStream.close();
        socket.close();
    }

}
