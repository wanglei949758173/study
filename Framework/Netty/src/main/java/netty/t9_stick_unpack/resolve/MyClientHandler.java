package netty.t9_stick_unpack.resolve;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * 客户端处理器
 *
 * @author Administrator
 * @since 1.0.0
 */
public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            byte[] sendMsg = "sent from client".getBytes("utf-8");

            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setLength(sendMsg.length);
            personProtocol.setContent(sendMsg);
            ctx.writeAndFlush(personProtocol);
        }

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("客户端接收到消息:");
        System.out.println("长度: " + length);
        System.out.println("内容: " + new String(content, Charset.forName("utf-8")));

        System.out.println("客户端接收到的消息数量: " + this.count);
    }
}
