/**
 * FileName: netty.tcppackage2
 * Author    王磊
 * Date      2019/4/30 22:04
 * Description: 处理器
 */
package netty.tcppackage2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * 处理器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("服务器端接收到的数据: ");
        System.out.println("长度: " + length);
        System.out.println("内容: " + new String(content, Charset.forName("utf-8")));

        System.out.println("服务器端接收到的消息数量: " + (++this.count));

        byte[] responseMsg = UUID.randomUUID().toString().getBytes("utf-8");

        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(responseMsg.length);
        personProtocol.setContent(responseMsg);
        ctx.writeAndFlush(personProtocol);
    }
}
