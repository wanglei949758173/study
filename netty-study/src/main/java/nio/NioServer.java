/**
 * FileName: NioServer
 * Author:   王磊
 * Date:     2019/3/23 18:24
 * Description: NIO 服务器
 */
package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * NIO 服务器
 *
 * @author wl
 * @since 1.0.0
 */
public class NioServer {
    // 保存所有在线的客户端
    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    // 事件处理
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey
                                .channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        String key = "【" + UUID.randomUUID().toString() + "】";
                        clientMap.put(key, client);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int count = client.read(readBuffer);

                        if (count > 0) {
                            readBuffer.flip();
                            Charset charset = Charset.forName("utf-8");
                            String receivedMessage = String.valueOf(charset.decode(
                                    readBuffer).array());

                            System.out.println(client + ":" + receivedMessage);

                            // 获取发送者的key值
                            String senderKey = null;
                            for (Map.Entry<String, SocketChannel> entry : clientMap
                                    .entrySet()) {
                                if (client == entry.getValue()) {
                                    senderKey = entry.getKey();
                                    break;
                                }
                            }

                            for (Map.Entry<String, SocketChannel> entry : clientMap
                                    .entrySet()) {
                                SocketChannel value = entry.getValue();

                                ByteBuffer writeBuffer = ByteBuffer.allocate(
                                        1024);
                                writeBuffer.put((senderKey + ":" + receivedMessage)
                                                        .getBytes());
                                writeBuffer.flip();

                                value.write(writeBuffer);
                            }


                        }
                    }

                    iterator.remove();
                }
            } catch (Exception e) {

            }
        }
    }
}
