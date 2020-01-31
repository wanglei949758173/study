package netty.t4_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class T3_CompositeByteBuf {
    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf heapBuffer = Unpooled.buffer(10);
        ByteBuf directBuffer = Unpooled.directBuffer(8);

        compositeByteBuf.addComponents(heapBuffer, directBuffer);
        compositeByteBuf.forEach(System.out::println);
    }
}
