/**
 * FileName: netty.handler
 * Author    王磊
 * Date      2019/4/28 21:57
 * Description: Byte转换到Long,继承自ReplayingDecoder
 */
package netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Byte转换到Long,继承自ReplayingDecoder
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 decode invoked!");
        out.add(in.readLong());
    }
}
