package netty.t8_codec.byte2long;

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
        System.out.println("MyLongToByteEncoder encode invoked!");
        System.out.println(msg);

        out.writeLong(msg);
    }
}
