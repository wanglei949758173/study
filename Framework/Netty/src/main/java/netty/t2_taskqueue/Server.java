package netty.t2_taskqueue;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
	public static void main(String[] args) throws Exception {
		// 创建bossGroup和workerGroup
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			// 初始化serverBootstrap
			ServerBootstrap serverBootstrap = new ServerBootstrap()
					.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					// 设置线程队列的连接个数
					.option(ChannelOption.SO_BACKLOG, 128)
					// 设置保持活动连接状
					.childOption(ChannelOption.SO_KEEPALIVE, true)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ServerHandler());
						}
					});

			ChannelFuture channelFuture = serverBootstrap.bind(6666).sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			// 关闭资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}