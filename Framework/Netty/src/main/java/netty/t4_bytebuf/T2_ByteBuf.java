package netty.t4_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class T2_ByteBuf {
	public static void main(String[] args) {
		ByteBuf byteBuf = Unpooled.copiedBuffer("王hello World", Charset.forName("utf-8"));

		// 堆缓冲
		if (byteBuf.hasArray()) {
			byte[] content = byteBuf.array();
			// 王hello world
			System.out.println(new String(content, 0, byteBuf.readableBytes(),
					Charset.forName("utf-8")));

			System.out.println("----------------------");

			System.out.println("arrayOffset：" + byteBuf.arrayOffset()); // 0
			System.out.println("readerIndex：" + byteBuf.readerIndex()); // 0
			System.out.println("writerIndex：" + byteBuf.writerIndex()); // 14
			System.out.println("capacity：" + byteBuf.capacity()); // 36 字符长度 * 编码集字符最大的长度

			int length = byteBuf.readableBytes();
			System.out.println("readableBytes：" + length); // 14

			for (int i = 0; i < byteBuf.readableBytes(); i++) {
				System.out.println("-------------------------");
				System.out.println((char) byteBuf.getByte(i));
			}

			System.out.println("--------------------------");
			System.out.println(byteBuf.getCharSequence(0, 4, Charset.forName("utf-8"))); // 王h
			System.out.println(byteBuf.getCharSequence(4, 6, 
					Charset.forName("utf-8"))); // ello w

		}
	}
}
