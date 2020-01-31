package netty.t1_tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	public static void main(String[] args) throws Exception {
		// 创建eventLoopGroup
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

		try {
			// 初始化bootstrap
			Bootstrap bootstrap = new Bootstrap().group(eventLoopGroup)
					.channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ClientHandler());
						}
					});

			ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666).sync();
			channelFuture.channel().closeFuture().sync();

		} finally {
			// 关闭资源
			eventLoopGroup.shutdownGracefully();
		}
	}
}
