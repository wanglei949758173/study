/**
 * FileName: TestFileLock9
 * Author:   王磊
 * Date:     2019/3/23 12:12
 * Description: 测试文件锁
 */
package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 测试文件锁
 *
 * @author wl
 * @since 1.0.0
 */
public class TestFileLock9 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("rdm.txt",
                                                                 "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileLock fileLock = fileChannel.lock(3, 6, true);

        System.out.println("valid:" + fileLock.isValid());
        System.out.println("lock type:" + fileLock.isShared());
    }
}
