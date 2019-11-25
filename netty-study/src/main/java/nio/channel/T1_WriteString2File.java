package nio.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class T1_WriteString2File {
	public static void main(String[] args) throws Exception {
		// 将"你好，NIO"写入文件testChannel1.txt
		String str = "你好，NIO";

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("testChannel1.txt");
			FileChannel channel = fos.getChannel();

			// 将str读入到ByteBuffer
			ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

			// 将buffer写入到channel
			channel.write(buffer);
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}
}
