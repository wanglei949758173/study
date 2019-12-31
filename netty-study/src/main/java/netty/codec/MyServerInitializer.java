package netty.codec;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;

/**
 * 服务初始化处理器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyLongToByteEncoder());
        pipeline.addLast(new MyServerHandler());
    }
}
