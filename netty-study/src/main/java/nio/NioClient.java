/**
 * FileName: NioClient
 * Author:   王磊
 * Date:     2019/3/23 18:55
 * Description: NIO 客户端程序
 */
package nio;

import com.sun.security.ntlm.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NIO 客户端程序
 *
 * @author wl
 * @since 1.0.0
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress(8899));

            while (true) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {
                    if (selectionKey.isConnectable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();

                        if (client.isConnectionPending()) {
                            client.finishConnect();
                            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                            writeBuffer.put((LocalDateTime.now() + "连接成功").getBytes());
                            writeBuffer.flip();
                            client.write(writeBuffer);

                            ExecutorService executorService = Executors.newSingleThreadExecutor(
                                    Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                writeBuffer.clear();
                                InputStreamReader input = new InputStreamReader(
                                        System.in);
                                BufferedReader bufferedReader = new BufferedReader(
                                        input);
                                try {
                                    String sendMessage = bufferedReader.readLine();
                                    writeBuffer.put(sendMessage.getBytes());
                                    writeBuffer.flip();
                                    client.write(writeBuffer);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel readChannel = (SocketChannel) selectionKey
                                .channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                        int readCount = readChannel.read(readBuffer);
                        if (readCount > 0) {
                            readBuffer.flip();
                            String receivedMessage = new String(readBuffer.array(),
                                                                0,
                                                                readCount);
                            System.out.println(receivedMessage);
                        }
                    }
                    selectionKeys.clear();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
