/**
 * FileName: netty.handler
 * Author    王磊
 * Date      2019/4/28 20:23
 * Description: Long 到Byte编码器
 */
package netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Long 到Byte编码器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encode invoked!");
        System.out.println(msg);

        out.writeLong(msg);
    }
}
