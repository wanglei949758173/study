/**
 * FileName: NewIOServer
 * Author:   王磊
 * Date:     2019/3/31 16:48
 * Description: NIO 服务
 */
package nio.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO 服务
 *
 * @author wl
 * @since 1.0.0
 */
public class NewIOServer {
    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();

        // 超时可重用
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            int readCount = 0;

            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                buffer.rewind();
            }
        }
    }
}
