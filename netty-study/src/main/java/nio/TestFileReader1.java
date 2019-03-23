/**
 * FileName: TestFileReader1
 * Author:   王磊
 * Date:     2019/3/23 10:37
 * Description: NIO Buffer的测试 file1.txt的内容复制到file2.txt
 */
package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO Buffer的测试 file1.txt的内容复制到file2.txt
 *
 * @author wl
 * @since 1.0.0
 */
public class TestFileReader1 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream =
                new FileInputStream("file1.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            System.out.println("char:" + (char)b);
        }

        fileChannel.close();
        fileInputStream.close();
    }
}
