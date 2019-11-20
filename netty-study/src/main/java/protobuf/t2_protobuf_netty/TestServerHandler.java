package protobuf.t2_protobuf_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protobuf.t2_protobuf_netty.PersonMessage.Person;

public class TestServerHandler extends SimpleChannelInboundHandler<PersonMessage.Person>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {
		System.out.println(msg.getName());
		System.out.println(msg.getAge());
		System.out.println(msg.getAddress());
	}

}
