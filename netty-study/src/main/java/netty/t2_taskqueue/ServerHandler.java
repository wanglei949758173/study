package netty.t2_taskqueue;

import java.util.concurrent.TimeUnit;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class ServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buffer = (ByteBuf) msg;
		// 执行一个长时间的业务处理
		// 业务处理1
		ctx.channel().eventLoop().execute(() -> {
			try {
				Thread.sleep(5000);
				ctx.writeAndFlush(Unpooled.copiedBuffer("业务处理已经完成", CharsetUtil.UTF_8));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// 业务处理2
		// 业务处理2会等待业务处理1完成后再执行，因为两个业务处理用的是一个eventLoop
		ctx.channel().eventLoop().execute(() -> {
			try {
				Thread.sleep(3000);
				ctx.writeAndFlush(Unpooled.copiedBuffer("业务处理已经完成2", CharsetUtil.UTF_8));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// 定时任务
		ctx.channel().eventLoop().schedule(() -> {
			System.out.println("定时任务执行了");
		}, 5, TimeUnit.SECONDS);

		System.out.println("客户端发送的消息是：" + buffer.toString(CharsetUtil.UTF_8));

		System.out.println("客户端的地址是：" + ctx.channel().remoteAddress());

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// 读完了数据
		ctx.writeAndFlush(Unpooled.copiedBuffer("hello,  客户端", CharsetUtil.UTF_8));
	}
}
