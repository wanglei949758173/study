/**
 * FileName: TestServerInitializer
 * Author:   王磊
 * Date:     2019/3/24 11:09
 * Description: 连接处理器
 */
package netty.httpserver1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 连接处理器
 *
 * @author wl
 * @since 1.0.0
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		ChannelPipeline pipeline = socketChannel.pipeline();

		pipeline.addLast("httpServerCodec", new HttpServerCodec());
		pipeline.addLast("testHttpServerHanler", new TestHttpServerHanler());
	}
}
