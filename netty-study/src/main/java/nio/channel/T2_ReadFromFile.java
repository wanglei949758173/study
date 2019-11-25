package nio.channel;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class T2_ReadFromFile {
	public static void main(String[] args) throws Exception {
		// 将testChannel1.txt的内容读取到程序中，并输出到控制台
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("testChannel1.txt");
			
			// 从文件读取到buffer
			FileChannel channel = fis.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(fis.available());
			channel.read(buffer);
			
			System.out.println(new String(buffer.array()));
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}
