package nio.channel;

import java.nio.ByteBuffer;

public class T8_DirectByteBuffer {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ByteBuffer buffer = ByteBuffer.allocateDirect(512);
	}
}
