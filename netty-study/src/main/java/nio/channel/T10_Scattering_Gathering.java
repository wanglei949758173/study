package nio.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.stream.Stream;

public class T10_Scattering_Gathering {
	public static void main(String[] args) throws Exception {
		// 测试scattering(分散)和gathering(收集)
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		InetSocketAddress socketAddress = new InetSocketAddress(6666);
		serverSocketChannel.bind(socketAddress);

		// 创建ByteBuffer[]
		ByteBuffer[] buffers = new ByteBuffer[3];
		buffers[0] = ByteBuffer.allocate(2);
		buffers[1] = ByteBuffer.allocate(3);
		buffers[2] = ByteBuffer.allocate(4);

		int messageLength = 2 + 3 + 4;
		SocketChannel socketChannel = serverSocketChannel.accept();
		System.out.println("client connect....");
		while (true) {
			System.out.println("============read=============");
			int byteRead = 0;
			while (byteRead < messageLength) {
				// 将数据从channel读取到buffers
				long read = socketChannel.read(buffers);
				byteRead += read;

				// 打印byteRead和buffer中关键参数的值
				System.out.println("byteRead：" + byteRead);
				Stream.of(buffers).map(buffer -> {
					return "position：" + buffer.position()
							+ "  |  "
							+ "limit："
							+ buffer.limit();
				});
			}

			// 读满了，将数据写回客户端
			System.out.println("============write=============");
			Stream.of(buffers).forEach(ByteBuffer::flip);
			int byteWritten = 0;
			while (byteWritten < messageLength) {
				long write = socketChannel.write(buffers);
				byteWritten += write;

				// 打印byteWritten和buffer中的关键参数
				System.out.println("byteWritten：" + byteWritten);
				Stream.of(buffers).map(buffer -> {
					return "position：" + buffer.position()
							+ "  |  "
							+ "limit："
							+ buffer.limit();
				});
			}

			// clear所有buffer
			Stream.of(buffers).forEach(ByteBuffer::clear);
			System.out.println("=============================");
			System.out.println("byteRead：" + byteRead
					+ "  |  "
					+ "byteWritten："
					+ byteWritten
					+ "  |  "
					+ "messageLength："
					+ messageLength);
		}
	}
}
