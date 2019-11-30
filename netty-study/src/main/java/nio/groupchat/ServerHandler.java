package nio.groupchat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class ServerHandler {

	/**
	 * 从channel中读取数据,返回数据
	 * 
	 * @param readChannel
	 *            通道
	 * @return 读取到的消息
	 * @throws Exception
	 */
	public String read(SocketChannel readChannel) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int read = readChannel.read(buffer);
		if (read > 0) {
			return new String(buffer.array(), 0, buffer.limit()).trim();
		} else {
			return null;
		}
	}

	/**
	 * 转发消息到其他通道
	 * 
	 * @param msg
	 *            消息
	 * @param otherChannels
	 *            其他通道
	 */
	public void forwardMsg(String msg, Set<SocketChannel> otherChannels) {
		otherChannels.forEach(channel -> {
			ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
			try {
				channel.write(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
