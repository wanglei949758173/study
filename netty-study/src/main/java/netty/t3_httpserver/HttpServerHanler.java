package netty.t3_httpserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class HttpServerHanler extends SimpleChannelInboundHandler<HttpObject> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg)
			throws Exception {
		if (msg instanceof HttpRequest) {
			HttpRequest request = (HttpRequest) msg;
			System.out.println("请求方式:" + request.method().name());

			URI uri = new URI(request.uri());
			if ("/favicon.ico".equals(uri.getPath())) {
				System.out.println("请求favicon.ico");
				return;
			}

			ByteBuf content = Unpooled.copiedBuffer("Hello，我是服务器", CharsetUtil.UTF_8);
			FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
					HttpResponseStatus.OK, content);
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=utf-8");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH,
					content.readableBytes());

			ctx.writeAndFlush(response);
		}
	}
}
