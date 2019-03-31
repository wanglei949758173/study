/**
 * FileName: NewIOClient
 * Author:   王磊
 * Date:     2019/3/31 18:12
 * Description: NIO 客户端
 */
package zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO 客户端
 *
 * @author wl
 * @since 1.0.0
 */
public class NewIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String fileName = "D:\\前端\\html+css\\源码、课件\\笔记.zip";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0,
                                                    fileChannel.size(),
                                                    socketChannel);

        System.out.println("发送总字节数：" + transferCount + "，耗时：" + (System.currentTimeMillis() - startTime));
    }

}
