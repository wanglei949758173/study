/**
 * FileName: TestReadOnlyBuffer6
 * Author:   王磊
 * Date:     2019/3/23 12:00
 * Description: 测试ReadOnlyBuffer
 */
package nio;

import java.nio.ByteBuffer;

/**
 * 测试ReadOnlyBuffer
 *
 * @author wl
 * @since 1.0.0
 */
public class TestReadOnlyBuffer6 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        ByteBuffer asReadOnlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(asReadOnlyBuffer.getClass());

        asReadOnlyBuffer.position(0);
//        asReadOnlyBuffer.put((byte) 2);
    }
}
