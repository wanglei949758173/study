/**
 * FileName: TestByteBuffer4
 * Author:   王磊
 * Date:     2019/3/23 11:48
 * Description: 测试ByteBuffer的API
 */
package nio;

import java.nio.ByteBuffer;

/**
 * 测试ByteBuffer的API
 *
 * @author wl
 * @since 1.0.0
 */
public class TestByteBuffer4 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byteBuffer.putInt(15);
        byteBuffer.putLong(400000000000000L);
        byteBuffer.putDouble(14.23535);
        byteBuffer.putChar('h');
        byteBuffer.putShort((short)2);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
    }

}
