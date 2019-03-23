/**
 * FileName: TestSelctor11
 * Author:   王磊
 * Date:     2019/3/23 15:12
 * Description: 测试Slector
 */
package nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 测试Slector
 *
 * @author wl
 * @since 1.0.0
 */
public class TestSelctor11 {
    public static void main(String[] args) throws Exception {
        int[] ports = new int[5];

        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();
        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            serverSocket.bind(address);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口:" + ports[i]);
        }

        while (true) {
            int numbers = selector.select();
            System.out.println("numbers:" + numbers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys:" + selectionKeys);

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey
                            .channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    iterator.remove();
                    System.out.println("获得客户端连接:" + socketChannel);
                } else if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    int byteRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();
                        int read = channel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }

                        byteBuffer.flip();
                        channel.write(byteBuffer);

                        byteRead += read;
                    }
                    System.out.println("读取:" + byteRead + ",来自于 " + channel);
                }
            }
        }
    }
}
