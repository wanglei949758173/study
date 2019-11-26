package nio.channel;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class T9_MappedByteBuffer {
	public static void main(String[] args) throws Exception {
		// MappedByteBuffer 可让文件直接在内存(堆外内存)修改,操作系统不需要拷贝一次
		RandomAccessFile randomAccessFile = new RandomAccessFile("mapperbuffer.txt","rw");
		
		FileChannel channel = randomAccessFile.getChannel();
		// 代表文件的第0-9个字节可以读写
		MappedByteBuffer mappedByteBuffer = channel.map(MapMode.READ_WRITE, 0, 10);
		
		mappedByteBuffer.put(1,(byte) 'J');
		mappedByteBuffer.put(2,(byte) 'A');
		mappedByteBuffer.put(3,(byte) 'V');
		mappedByteBuffer.put(4,(byte) 'A');
		
		channel.close();
		randomAccessFile.close();
	}
}
