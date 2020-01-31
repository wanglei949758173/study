package nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 群聊系统服务端
 * 
 * @author Administrator
 *
 */
public class GroupChatServer {
	// 监听端口
	private static final int PORT = 6666;

	// 选择器
	private Selector selector;

	// 监听的ServerSocketChannel
	private ServerSocketChannel listenChannel;

	private ServerHandler serverHandler;

	// 初始化
	public GroupChatServer(ServerHandler handler) {
		this.serverHandler = handler;
		try {
			// 初始化监听的ServerSocketChannel
			listenChannel = ServerSocketChannel.open();
			listenChannel.bind(new InetSocketAddress(PORT));
			listenChannel.configureBlocking(false);

			// 注册到selector
			selector = Selector.open();
			listenChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 启动服务器
	public void start() throws Exception {
		// 启动成功
		System.out.println(
				"started successful... listening on " + GroupChatServer.PORT);
		while (true) {
			int selectedCount = selector.select();

			if (selectedCount <= 0) {
				continue;
			} else {
				// 由准备好的channel
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				selectedKeys.forEach(selectedKey -> {
					try {
						if (selectedKey.isAcceptable()) {
							// 有连接
							ServerSocketChannel channel = (ServerSocketChannel) selectedKey
									.channel();
							SocketChannel acceptChannel = channel.accept();
							acceptChannel.configureBlocking(false);
							// 注册读事件
							acceptChannel.register(selector, SelectionKey.OP_READ);

							System.out.println(
									acceptChannel.getRemoteAddress() + " is online.....");
						} else if (selectedKey.isReadable()) {
							// 有读事件
							SocketChannel readChannel = (SocketChannel) selectedKey
									.channel();
							String msg = serverHandler.read(readChannel);
							// 转发消息到其他通道
							Set<SelectionKey> keys = selector.keys();
							Set<SocketChannel> otherChannels = keys.stream()
									.filter(key -> key != selectedKey
											&& key.channel() instanceof SocketChannel)
									.map(key -> (SocketChannel) key.channel())
									.collect(Collectors.toSet());
							if (msg != null) {
								System.out.println("forward msg：" + msg);
								serverHandler.forwardMsg(msg, otherChannels);
							} else {
								System.out.println("消息为null");
							}
						}
					} catch (Exception e) {
						try {
							SelectableChannel offlineChannel = selectedKey.channel();
							if (offlineChannel instanceof SocketChannel) {
								System.out.println(((SocketChannel)offlineChannel).getRemoteAddress() + " is offline...");
							} else {
								System.out.println("connetct failed...");
							}
			                //取消注册
							selectedKey.cancel();
			                //关闭通道
							offlineChannel.close();
			            }catch (IOException ex) {
			            	ex.printStackTrace();;
			            }
					}
				});

				// 处理完所有SelectionKey，清空selectedKeys
				selectedKeys.clear();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		GroupChatServer server = new GroupChatServer(new ServerHandler());
		server.start();
	}
}
