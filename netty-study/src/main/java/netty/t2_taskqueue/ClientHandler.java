package netty.t2_taskqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 通道激活时被调用
		ctx.writeAndFlush(
				Unpooled.copiedBuffer("hello, server: 我是客户端", CharsetUtil.UTF_8));
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 有读事件
		ByteBuf buf = (ByteBuf) msg;
		System.out.println("服务器回复的消息:" + buf.toString(CharsetUtil.UTF_8));
		System.out.println("服务器的地址： " + ctx.channel().remoteAddress());
	}
}
