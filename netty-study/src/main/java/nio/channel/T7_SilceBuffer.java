package nio.channel;

import java.nio.ByteBuffer;

public class T7_SilceBuffer {
	public static void main(String[] args) {
		// buffer:0,1,2,3,4....9
		ByteBuffer buffer = ByteBuffer.allocate(10);
		for (int i = 0; i < buffer.capacity(); i++) {
			buffer.put((byte) i);
		}

		// position：2,limit:6
		buffer.position(2);
		buffer.limit(6);
		ByteBuffer sliceBuffer = buffer.slice();
		
		// buffer:0,2,4,6...18
		for (int i = 0; i < sliceBuffer.capacity(); i++) {
			byte b = sliceBuffer.get();
			b *= 2;
			sliceBuffer.put(i, b);
		}

		System.out.println("buffer:");
		buffer.position(0);
		buffer.limit(buffer.capacity());
		// 0,1,4,6,8,10,6,7..9
		while (buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}
		
		System.out.println("-------------");
		System.out.println("sliceBuffer：");
		sliceBuffer.position(0);
		sliceBuffer.limit(sliceBuffer.capacity());
		// 4,6,8,10
		while (sliceBuffer.hasRemaining()) {
			System.out.println(sliceBuffer.get());
		}

	}
}
