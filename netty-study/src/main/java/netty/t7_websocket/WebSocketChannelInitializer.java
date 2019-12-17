package netty.t7_websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		// 因为基于http协议，使用http的编码和解码器
		pipeline.addLast(new HttpServerCodec());
		// 以块的方式写
		pipeline.addLast(new ChunkedWriteHandler());
		// http数据在传输过程中是分段，HtppObjectAggregator可以将多个段聚合
		// 这也就是为什么当浏览器发送大量数据时，就会发出多次http请求
		pipeline.addLast(new HttpObjectAggregator(8192));
		
		// 对应 websocket ，它的数据是以 帧(frame)形式传递
		// WebSocketFrame 下面有六个子类
		// 当浏览器访问ws://localhost:xxxx/ws时
		// WebSocketServerProtocolHandler的功能是将http协议升级为ws协议
		// 是通过一个状态码101
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

		// 自定义的 handler，处理业务逻辑
		pipeline.addLast(new TextWebSocketFrameHandler());
	}
}
