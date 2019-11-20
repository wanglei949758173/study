package protobuf.t2_protobuf_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protobuf.t2_protobuf_netty.PersonMessage.Person;

public class TestClientHandler extends SimpleChannelInboundHandler<PersonMessage.Person> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 构造消息
		Person person = PersonMessage.Person.newBuilder().setName("李四").setAge(26)
				.setAddress("北京").build();
		
		ctx.writeAndFlush(person);
	}

}
