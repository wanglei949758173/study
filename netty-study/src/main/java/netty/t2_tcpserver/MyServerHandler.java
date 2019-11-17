/**
 * FileName: MyServerHandler
 * Author:   王磊
 * Date:     2019/3/31 9:45
 * Description: 服务Handler
 */
package netty.t2_tcpserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * 服务Handler
 *
 * @author wl
 * @since 1.0.0
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println(ctx.channel().remoteAddress() + "," + msg);
		ctx.channel().writeAndFlush("from Server:" + UUID.randomUUID());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
