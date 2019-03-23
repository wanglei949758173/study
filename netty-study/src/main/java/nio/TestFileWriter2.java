/**
 * FileName: TestFileWriter2
 * Author:   王磊
 * Date:     2019/3/23 11:15
 * Description: 测试将字符串写入到文件中
 */
package nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试将字符串写入到文件中
 *
 * @author wl
 * @since 1.0.0
 */
public class TestFileWriter2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("file2.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] messages = "你好 我好 大家好".getBytes("utf-8");

        for (int i = 0; i < messages.length; i++) {
            byte message = messages[i];
            byteBuffer.put(message);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileChannel.close();
        fileOutputStream.close();
    }
}
