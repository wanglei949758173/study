/**
 * FileName: TestSliceBuffer5
 * Author:   王磊
 * Date:     2019/3/23 11:52
 * Description: 测试SliceBuffer的API
 */
package nio;

import java.nio.ByteBuffer;

/**
 * 测试SliceBuffer的API
 *
 * @author wl
 * @since 1.0.0
 */
public class TestSliceBuffer5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer sliceBuffer = buffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get();
            b *= 2;
            sliceBuffer.put(i, b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
