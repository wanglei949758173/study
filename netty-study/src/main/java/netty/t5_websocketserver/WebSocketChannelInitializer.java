/**
 * FileName: WebSocketChannelInitializer
 * Author:   王磊
 * Date:     2019/3/31 12:08
 * Description: websocket 服务器初始化器
 */
package netty.t5_websocketserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * websocket 服务器初始化器
 *
 * @author wl
 * @since 1.0.0
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		pipeline.addLast(new HttpServerCodec());
		pipeline.addLast(new ChunkedWriteHandler());
		pipeline.addLast(new HttpObjectAggregator(8192));
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

		pipeline.addLast(new TextWebSocketFrameHandler());
	}
}
