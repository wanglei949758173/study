/**
 * FileName: netty.handler
 * Author    王磊
 * Date      2019/4/28 20:33
 * Description: 客户端处理器
 */
package netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * 客户端处理器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws
            Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output:" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(123456L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}