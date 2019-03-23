/**
 * FileName: TestNIOServer10
 * Author:   王磊
 * Date:     2019/3/23 14:28
 * Description: NIO Server
 */
package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.stream.Stream;

/**
 * NIO Server
 *
 * @author wl
 * @since 1.0.0
 */
public class TestNIOServer10 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);

        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];

        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int byteRead = 0;

            while (byteRead < messageLength) {
                long read = socketChannel.read(buffers);
                byteRead += read;

                System.out.println("byteRead:" + byteRead);

                Stream.of(buffers).
                        map(buffer -> "position:" + buffer.position() + ",limit:" + buffer
                                .limit()).forEach(System.out::println);
            }

            // 读满了，将发送内容写回到客户端
            Stream.of(buffers).forEach(ByteBuffer::flip);

            long byteWritten = 0;
            while (byteWritten < messageLength) {
                long write = socketChannel.write(buffers);
                byteWritten += write;
            }

            // 清空Buffer，保证继续读取客户端发送的内容
            Stream.of(buffers).forEach(ByteBuffer::flip);
            System.out.println("byteRead:" + byteRead + ",byteWritten:" +
                                       byteWritten + ",messageLength:" + messageLength);
        }

    }

}
