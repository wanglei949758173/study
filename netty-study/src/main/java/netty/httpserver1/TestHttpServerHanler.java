/**
 * FileName: TestHttpServerHanler
 * Author:   王磊
 * Date:     2019/3/24 11:13
 * Description: 客户端请求处理器
 */
package netty.httpserver1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * 客户端请求处理器
 *
 * @author wl
 * @since 1.0.0
 */
public class TestHttpServerHanler
        extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                HttpObject msg) throws Exception {
        System.out.println(msg.getClass());

        System.out.println(ctx.channel().remoteAddress());
        Thread.sleep(8000);

        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            System.out.println("请求方式:" + request.method().name());

            URI uri = new URI(request.uri());
            if ("favicon.ico".equals(uri.getPath())) {
                System.out.println("请求favicon.ico");
                return;
            }

            ByteBuf content = Unpooled.copiedBuffer("Hello World",
                                                    CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                                                                    HttpResponseStatus.OK,
                                                                    content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);
            ctx.channel().close();
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        super.channelActive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered");
        super.channelRegistered(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler added");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws
                                                               Exception {
        System.out.println("channel unregistered");
        super.channelUnregistered(ctx);
    }

}
