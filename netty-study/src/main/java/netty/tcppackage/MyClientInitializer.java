/**
 * FileName: MyClientInitializer
 * Author:   王磊
 * Date:     2019/3/31 9:51
 * Description: 客户端初始化器
 */
package netty.tcppackage;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * 客户端初始化器
 *
 * @author wl
 * @since 1.0.0
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyClientHanler());
    }
}
