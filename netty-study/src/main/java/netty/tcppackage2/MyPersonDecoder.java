/**
 * FileName: netty.tcppackage2
 * Author    王磊
 * Date      2019/4/30 21:58
 * Description: person解码器
 */
package netty.tcppackage2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * person解码器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyPersonDecoder extends ReplayingDecoder<PersonProtocol> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("MyPersonDecoder decode invoked!");

        int length = in.readInt();

        byte[] content = new byte[length];
        in.readBytes(content);

        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(length);
        personProtocol.setContent(content);
        out.add(personProtocol);

    }
}
