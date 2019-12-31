/**
 * FileName: netty.handler
 * Author    王磊
 * Date      2019/4/28 20:27
 * Description: byte到Long类型的解码器
 */
package netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * byte到Long类型的解码器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println(in.readableBytes());
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
