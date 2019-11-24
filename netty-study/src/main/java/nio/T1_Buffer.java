package nio;

import java.nio.IntBuffer;

// 测试buffer的使用
public class T1_Buffer {
	public static void main(String[] args) {
		IntBuffer buffer = IntBuffer.allocate(6);
		// 向buffer中写入数据
		for (int i = 0; i < buffer.capacity(); i++) {
			buffer.put(i * i);
		}
		
		// 从buffer中读取数据
		buffer.flip(); // 转换模式，由写转换为读取
		while (buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}
	}
}
