/**
 * FileName: netty.handler
 * Author    王磊
 * Date      2019/4/28 20:18
 * Description: 服务初始化处理器
 */
package netty.handler;

import io.netty.channel.*;

/**
 * 服务初始化处理器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyServerInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyLongToByteEncoder());
        pipeline.addLast(new MyServerHandler());
    }
}
