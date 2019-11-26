package nio.channel;

import java.nio.ByteBuffer;

public class T6_ReadOnlyBuffer {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(512);
		
		buffer.put((byte) 0xFF);
		buffer.put((byte) 44);
		
		// 模式转换
		buffer.flip();
		ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
		while (readOnlyBuffer.hasRemaining()) {
			System.out.println(readOnlyBuffer.get());
		}
		
		readOnlyBuffer.put((byte) 3);// java.nio.ReadOnlyBufferException
	}
}
