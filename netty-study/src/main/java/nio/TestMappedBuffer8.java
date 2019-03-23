/**
 * FileName: TestMappedBuffer8
 * Author:   王磊
 * Date:     2019/3/23 12:07
 * Description: 测试MappedByteBuffer
 */
package nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试MappedByteBuffer
 *
 * @author wl
 * @since 1.0.0
 */
public class TestMappedBuffer8 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("mapperbuffer.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,
                                               0,
                                               5);
        mappedByteBuffer.put(0, (byte)'z');
        mappedByteBuffer.put(3, (byte)'c');
        fileChannel.close();
        randomAccessFile.close();

        // idea中看不到修改，只有到系统中才能看到修改
    }

}
