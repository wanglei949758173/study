package netty.t4_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class T1_ByteBuf {
	public static void main(String[] args) {
		ByteBuf buffer = Unpooled.buffer(10);

		for (int i = 0; i < 10; i++) {
			buffer.writeByte(i);
		}

		// 不会改变readerIndex
		// for (int i = 0; i < buffer.capacity(); i++) {
		// System.out.println(buffer.getByte(i));
		// }

		// 会改变bytebuf中的readerIndex
		for (int i = 0; i < buffer.capacity(); i++) {
			System.out.println(buffer.readByte());
		}
	}
}
