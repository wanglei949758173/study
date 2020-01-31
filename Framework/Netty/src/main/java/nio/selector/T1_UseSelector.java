package nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class T1_UseSelector {
	public static void main(String[] args) throws Exception {
		// 测试使用selector
		// 创建5个ServerSocketChannel，将其注册到Selector上
		final int serverSize = 5;

		Selector selector = Selector.open();
		for (int i = 0; i < serverSize; i++) {
			// 初始化ServerSocketChannel
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);

			// 创建5个socket
			ServerSocket socket = serverSocketChannel.socket();
			int port = 50000 + i;
			socket.bind(new InetSocketAddress(port));

			// 将ServerSocketChannel注册在selector上
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("listening at：" + port);
		}

		while (true) {
			int selectCount = selector.select();
			System.out.println("selectCount:" + selectCount);
			if (selectCount <= 0) {
				continue;
			}

			// 有事件发生
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if (selectionKey.isAcceptable()) {
					// 已连接
					ServerSocketChannel serverSocketChannel =
							(ServerSocketChannel) selectionKey.channel();
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
					// 注册读事件
					socketChannel.register(selector, SelectionKey.OP_READ);
					
					iterator.remove();
					System.out.println("connect as " + socketChannel);
				} else if (selectionKey.isReadable()) {
					// 已有可读取的数据
					SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
					
					// 从socketChannel中读取数据并打印
					int byteRead = 0;
					ByteBuffer buffer = ByteBuffer.allocate(512);
					while (true) {
						buffer.clear();
						int read = socketChannel.read(buffer);
						if (read <= 0) {
							break;
						}
						
						byteRead += read;
					}
					iterator.remove();
					System.out.println("read: " + byteRead + "byte,from " + socketChannel);
				}
			}
		}
	}
}
