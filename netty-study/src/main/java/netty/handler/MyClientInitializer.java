/**
 * FileName: netty.handler
 * Author    王磊
 * Date      2019/4/28 20:31
 * Description: 客户端初始化器
 */
package netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * 客户端初始化器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyClientInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyLongToByteEncoder());
        pipeline.addLast(new MyClientHandler());
    }
}
