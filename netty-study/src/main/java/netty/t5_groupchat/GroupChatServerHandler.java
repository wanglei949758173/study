package netty.t5_groupchat;

import java.time.LocalDateTime;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
	// 定义一个 channle 组，管理所有的 channel
	// GlobalEventExecutor.INSTANCE 是全局的事件执行器，是一个单例
	private static ChannelGroup channelGroup = new DefaultChannelGroup(
			GlobalEventExecutor.INSTANCE);

	// 有读事件,读取消息,转发给其他客户端
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		Channel thisChannel = ctx.channel();
		channelGroup.forEach(channel -> {
			if (channel != thisChannel) {
				channel.writeAndFlush(LocalDateTime.now().toString() + ", "
						+ channel.remoteAddress() + "说: " + msg + "\n");
			} else {
				// 自己,回显消息
				channel.writeAndFlush(
						LocalDateTime.now().toString() + ", " + "【自己】说: " + msg + "\n");
			}
		});
	}

	// 连接建立,有客户端上线
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		channelGroup.add(channel);

		// 提示其他客户端
		channelGroup.writeAndFlush(LocalDateTime.now().toString() + ", "
				+ channel.remoteAddress() + "加入聊天\n");
	}

	// 连接断开，有客户端离线
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();

		// 提示其他客户端
		channelGroup.writeAndFlush(LocalDateTime.now().toString() + ", "
				+ channel.remoteAddress() + "离开了\n");
	}

	// channel处理激活状态
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress() + "上线了~");
	}

	// channel处于不活动状态
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress() + "下线了~");
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
	}

}
