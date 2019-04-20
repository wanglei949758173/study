package netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class ByteBufTest1 {
    public static void main(String[] args) {
        ByteBuf byteBuf =
                Unpooled.copiedBuffer("王hello World", Charset.forName("utf-8"));

        // 堆缓冲
        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();
            System.out.println(new String(content, Charset.forName("utf-8"))); //王hello world

            System.out.println(byteBuf.arrayOffset()); // 0
            System.out.println(byteBuf.readerIndex()); // 0
            System.out.println(byteBuf.writerIndex()); // 14
            System.out.println(byteBuf.capacity()); // 36 字符长度 * 编码集字符最大的长度

            int length = byteBuf.readableBytes();
            System.out.println(length); // 14

            for (int i = 0; i < byteBuf.readableBytes(); i++) {
                System.out.println((char) byteBuf.getByte(i));
            }

            System.out.println(byteBuf.getCharSequence(0, 4, Charset.forName("utf-8"))); // 王h
            System.out.println(byteBuf.getCharSequence(4, 6, Charset.forName("utf-8"))); // ello w


        }
    }
}
