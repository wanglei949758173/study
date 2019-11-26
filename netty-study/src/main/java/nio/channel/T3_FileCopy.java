package nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class T3_FileCopy {
	public static void main(String[] args) throws Exception {
		// 测试文件拷贝
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("input.txt");
			fos = new FileOutputStream("output.txt");
			FileChannel inputChannel = fis.getChannel();
			FileChannel outputChannel = fos.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(512);
			while (true) {
				// clear
				buffer.clear();
				
				// 循环读取,从inputChannel读取到buffer中
				int read = inputChannel.read(buffer);
				if (read == -1) {
					// 读取结束
					break;
				}
				
				// 切换模式
				buffer.flip();
				// 从buufer中写入到outputChannel
				outputChannel.write(buffer);
				
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}
}
