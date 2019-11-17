/**
 * FileName: MyChatClientHandler
 * Author:   王磊
 * Date:     2019/3/31 10:17
 * Description: 聊天客户端Handler
 */
package netty.t3_chatserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 聊天客户端Handler
 *
 * @author wl
 * @since 1.0.0
 */
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println(msg);
	}
}
