package netty.t1_tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class ServerHandler extends ChannelInboundHandlerAdapter{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buffer = (ByteBuf) msg;
		System.out.println("客户端发送的消息是：" + buffer.toString(CharsetUtil.UTF_8));
		
		System.out.println("客户端的地址是：" + ctx.channel().remoteAddress());
		
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// 读完了数据
		ctx.writeAndFlush(Unpooled.copiedBuffer("hello,  客户端", CharsetUtil.UTF_8));
	}
}
