/**
 * FileName: NewIOClient
 * Author:   王磊
 * Date:     2019/3/31 18:12
 * Description: NIO 客户端
 */
package nio.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO 客户端
 *
 * @author wl
 * @since 1.0.0
 */
public class NewIOClient {
	public static void main(String[] args) throws Exception {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("localhost", 8899));
		socketChannel.configureBlocking(true);

		String fileName = "D:\\test\\data.zip";
		FileInputStream fis = new FileInputStream(fileName);
		FileChannel fileChannel = fis.getChannel();

		long startTime = System.currentTimeMillis();
		long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

		fis.close();
		fileChannel.close();
		System.out.println("发送总字节数：" + transferCount + "，耗时："
				+ (System.currentTimeMillis() - startTime));
	}

}
