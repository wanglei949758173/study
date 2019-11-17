/**
 * FileName: MyServerInitializer
 * Author:   王磊
 * Date:     2019/3/31 10:26
 * Description: 服务初始化器
 */
package netty.t4_heartbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 服务初始化器
 *
 * @author wl
 * @since 1.0.0
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		pipeline.addLast(new IdleStateHandler(5, 7, 3, TimeUnit.SECONDS));
		pipeline.addLast(new MyServerHandler());
	}
}
