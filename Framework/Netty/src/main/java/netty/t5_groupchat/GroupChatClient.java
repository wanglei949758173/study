package netty.t5_groupchat;

import java.util.Scanner;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class GroupChatClient {

	private final String host;
	private final int port;

	public GroupChatClient(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}

	// 连接服务器
	public Channel connect() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();

		Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ChannelPipeline pipeline = ch.pipeline();
						// 添加string编解码器和自定义处理器
						pipeline.addLast("decoder", new StringDecoder());
						pipeline.addLast("encoder", new StringEncoder());
						pipeline.addLast("groupChatClientHandler",
								new GroupChatClientHandler());
					}
				});
		ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
		channelFuture.channel().closeFuture();
		return channelFuture.channel();

	}

	// 发送消息
	public void sendMsg(String msg, Channel channel) {
		channel.writeAndFlush(msg + "\r\n");
	}

	public static void main(String[] args) throws Exception {
		GroupChatClient groupChatClient = new GroupChatClient("127.0.0.1", 6666);
		Channel channel = groupChatClient.connect();
		System.out.println("--" + channel.localAddress() + "--");
		Scanner scanner = new Scanner(System.in);
		try {
			while (scanner.hasNextLine()) {
				String msg = scanner.nextLine();
				groupChatClient.sendMsg(msg, channel);
			}
		} finally {
			scanner.close();
		}
	}

}
