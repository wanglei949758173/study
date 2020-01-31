package nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class T4_TransferFrom {
	public static void main(String[] args) throws Exception{
		// 使用transferFrom完成文件的拷贝
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			fis = new FileInputStream("D:\\test\\a.jpg");
			fos = new FileOutputStream("D:\\test\\b.jpg");
			inputChannel = fis.getChannel();
			outputChannel =fos.getChannel();
			
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (inputChannel != null) {
				inputChannel.close();
			}
			if (outputChannel != null) {
				outputChannel.close();
			}
		}
	}
}
