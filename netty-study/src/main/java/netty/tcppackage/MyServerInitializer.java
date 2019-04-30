/**
 * FileName: netty.tcppackage
 * Author    王磊
 * Date      2019/4/30 21:35
 * Description: 初始化器
 */
package netty.tcppackage;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * 初始化器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyServerHandler());
    }
}
