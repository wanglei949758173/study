package netty.t9_stick_unpack.problem;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	private int count = 0;

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		// 读取消息
		byte[] msgData = new byte[msg.readableBytes()];
		msg.readBytes(msgData);

		String msgStr = new String(msgData, CharsetUtil.UTF_8);

		System.out.println();
		System.out.println();
		System.out.println("客户端收到消息：" + msgStr);
		System.out.println("客户端接收到的消息量：" + (++this.count));
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		// 发送10条消息
		for (int i = 0; i < 10; i++) {
			ByteBuf sendMsgData = Unpooled.copiedBuffer("hello server：" + i,
					CharsetUtil.UTF_8);
			ctx.writeAndFlush(sendMsgData);
		}
	}
}
