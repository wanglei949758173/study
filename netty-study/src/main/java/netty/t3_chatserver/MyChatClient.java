/**
 * FileName: MyChatClient
 * Author:   王磊
 * Date:     2019/3/31 10:12
 * Description: 聊天客户端
 */
package netty.t3_chatserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 聊天客户端
 *
 * @author wl
 * @since 1.0.0
 */
public class MyChatClient {
	public static void main(String[] args) throws Exception {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
					.handler(new MyChatClientInitializer());

			Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			for (;;) {
				channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
			}

		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}
}
