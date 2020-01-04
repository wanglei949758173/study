package netty.t9_stick_unpack.problem;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
	private int count = 0;

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		// 读取消息
		byte[] msgData = new byte[msg.readableBytes()];
		msg.readBytes(msgData);

		String msgStr = new String(msgData, CharsetUtil.UTF_8);

		System.out.println();
		System.out.println();
		System.out.println("服务器收到消息：" + msgStr);
		System.out.println("服务器接收到的消息量：" + (++this.count));

		// 回送消息给客户端
		ByteBuf sendMsg = Unpooled.copiedBuffer(UUID.randomUUID().toString() + " ",
				CharsetUtil.UTF_8);
		ctx.writeAndFlush(sendMsg);
	}

}
