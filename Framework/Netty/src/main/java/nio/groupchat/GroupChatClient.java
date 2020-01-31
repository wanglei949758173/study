package nio.groupchat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.Set;

/**
 * 群聊客户端
 * 
 * @author Administrator
 *
 */
public class GroupChatClient {
	private static final String REMOTE_IP = "127.0.0.1";
	private static final int REMOTE_PORT = 6666;

	private Selector selector;
	private SocketChannel socketChannel;
	private String username;

	public GroupChatClient(String userName) {
		this.username = userName;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);

			// 注册读事件
			selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// 输入用户名
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("please input your username");
			String username = scanner.nextLine();
			GroupChatClient client = new GroupChatClient(username);

			// 连接
			client.connect();

			// 启动一个线程,每三秒读取一次消息
			new Thread(() -> {
				try {
					String readMsg = client.readMsg();
					if (readMsg != null) {
						System.out.println(readMsg);
					}
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();

			while (true) {
				// 读取用户要发送的消息
				if (scanner.hasNextLine()) {
					String sendMsg = scanner.nextLine();
					client.sendMsg(sendMsg);
				}
			}
		} finally {
			scanner.close();
		}

	}

	/**
	 * 发送消息
	 * 
	 * @param sendMsg
	 *            要发送的消息
	 * @throws Exception
	 */
	private void sendMsg(String sendMsg) throws Exception {
		this.socketChannel
				.write(ByteBuffer.wrap((this.username + "：" + sendMsg).getBytes()));
	}

	/**
	 * 连接服务器
	 * 
	 * @throws Exception
	 */
	private void connect() throws Exception {
		// 连接服务器
		this.socketChannel.connect(new InetSocketAddress(REMOTE_IP, REMOTE_PORT));
		while (true) {
			int selectedCount = selector.select();
			if (selectedCount <= 0) {
				continue;
			} else {
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				selectedKeys.forEach(currentKey -> {
					try {
						// 已经可以连接
						if (currentKey.isConnectable()) {
							if (this.socketChannel.isConnectionPending()) {
								// 必须调用此方法来完成连接
								this.socketChannel.finishConnect();
							}
							SocketChannel connectChannel = (SocketChannel) currentKey
									.channel();
							connectChannel.register(this.selector, SelectionKey.OP_READ);
							System.out.println("connect successful, your username is "
									+ this.username);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
				selectedKeys.clear();
				break;
			}
		}
	}

	/**
	 * 读取服务器的消息
	 * 
	 * @return
	 * @throws Exception
	 */
	private String readMsg() throws Exception {
		int selectedCount = selector.select();
		if (selectedCount <= 0) {
			return null;
		} else {
			String msg = null;
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			for (SelectionKey currentKey : selectedKeys) {
				// 有读事件
				if (currentKey.isReadable()) {
					SocketChannel channel = (SocketChannel) currentKey.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					channel.read(buffer);
					msg = new String(buffer.array(), 0, buffer.limit());
				}
			}
			selectedKeys.clear();
			return msg;
		}
	}
}
