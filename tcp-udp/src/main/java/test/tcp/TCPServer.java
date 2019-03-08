/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TCPServer.java  
 * 作者 王磊 
 * 编写日期 2019年3月7日    
 */
package test.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务器
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class TCPServer {
	/**
	 * 服务器套接字
	 */
	private ServerSocket serverSocket = null;

	public TCPServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	/**
	 * 启动方法
	 */
	public void start() {
		System.out.println("start success....");
		while (true) {
			try {
				Socket acceptSocket = serverSocket.accept();
				System.out.println(
						acceptSocket.getInetAddress().getHostAddress() + ":"
								+ acceptSocket.getPort()
								+ "连接了");
				// 发送消息
				sendMsg("哈哈，你也好啊!",acceptSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 发送消息
	 * @param msg 要发送的消息
	 * @param socket 套接字
	 */
	public void sendMsg(String msg, Socket socket) {
		// 获取客户端发送的消息
		InputStream inputStream;
		try {
			inputStream = socket.getInputStream();
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			if (data.length > 0) {
				System.out
						.println("收到" + socket.getInetAddress().getHostAddress()
								+ ":"
								+ socket.getPort()
								+ "发送的消息："
								+ new String(data));
				OutputStream outputStream = socket.getOutputStream();
				outputStream.write(msg.getBytes());
				outputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		TCPServer server = new TCPServer(8080);
		server.start();
	}
}
