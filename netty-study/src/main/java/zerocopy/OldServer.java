/**
 * FileName: OldServer
 * Author:   王磊
 * Date:     2019/3/31 16:35
 * Description: 传统的方式操作系统文件的服务器
 */
package zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统的方式操作系统文件的服务器
 *
 * @author wl
 * @since 1.0.0
 */
public class OldServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8899);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {
                byte[] byteArray = new byte[4096];

                while (true) {
                    int readCount = dataInputStream.read(byteArray,
                                                         0,
                                                         byteArray.length);
                    if (-1 == readCount) {
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
