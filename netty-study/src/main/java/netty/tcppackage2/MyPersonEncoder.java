/**
 * FileName: netty.tcppackage2
 * Author    王磊
 * Date      2019/4/30 22:02
 * Description: person编码器
 */
package netty.tcppackage2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * person编码器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyPersonEncoder encode invoked!");

        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
