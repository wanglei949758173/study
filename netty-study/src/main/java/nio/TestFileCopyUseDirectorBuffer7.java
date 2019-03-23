/**
 * FileName: TestFileCopy3
 * Author:   王磊
 * Date:     2019/3/23 11:25
 * Description: 测试文件的拷贝
 */
package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试文件的拷贝
 *
 * @author wl
 * @since 1.0.0
 */
public class TestFileCopyUseDirectorBuffer7 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);

        while (true) {

            byteBuffer.clear();

            int read = inputChannel.read(byteBuffer);
            if (-1 == read) {
                break;
            }

            byteBuffer.flip();
            outChannel.write(byteBuffer);
        }

        inputChannel.close();
        outChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

}
