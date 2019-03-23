/**
 * FileName: NIOHelloWorld
 * Author:   王磊
 * Date:     2019/3/23 10:50
 * Description: NIO入门程序
 */
package nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * NIO入门程序
 *
 * @author wl
 * @since 1.0.0
 */
public class NIOHelloWorld {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
