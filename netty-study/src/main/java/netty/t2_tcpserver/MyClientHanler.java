/**
 * FileName: MyClientHanler
 * Author:   王磊
 * Date:     2019/3/31 9:53
 * Description: 客户端Handler
 */
package netty.t2_tcpserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * 客户端Handler
 *
 * @author wl
 * @since 1.0.0
 */
public class MyClientHanler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println(ctx.channel().remoteAddress());
		System.out.println("client output:" + msg);
		ctx.writeAndFlush("from client:" + LocalDateTime.now());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush("来自于客户端的问候");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
