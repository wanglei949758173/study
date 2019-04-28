/**
 * FileName: netty.handler
 * Author    王磊
 * Date      2019/4/28 20:20
 * Description: 服务器处理器
 */
package netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 服务器处理器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + ", " + msg);

        ctx.writeAndFlush(654321L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        super.exceptionCaught(ctx, cause);
    }
}
