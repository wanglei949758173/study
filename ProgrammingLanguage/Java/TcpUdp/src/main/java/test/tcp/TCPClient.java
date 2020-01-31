/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TCPClient.java  
 * 作者 王磊 
 * 编写日期 2019年3月7日    
 */
package test.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP客户端
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class TCPClient {
	/**
	 * 连接套接字
	 */
	Socket socket = null;

	/**
	 * 连接服务器
	 * @param serverIP 服务器IP
	 * @param serverPort 服务器端口
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void connect(String serverIP, int serverPort)
			throws UnknownHostException,
			IOException {
		socket = new Socket(serverIP, serverPort);
	}
	
	/**
	 * 发送消息
	 * @param msg 消息
	 * @param socket 套接字
	 * @throws IOException 
	 */
	public void sendMsg(String msg) throws IOException {
		if (socket != null) {
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(msg.getBytes("utf-8"));
			outputStream.flush();
		}
	}
	
	/**
	 * 接收消息
	 * @return 接收到的消息
	 * @throws IOException 
	 */
	public String receiveMsg() throws IOException {
		if (socket != null) {
			InputStream inputStream = socket.getInputStream();
			byte[] data = new byte[1024];
			inputStream.read(data);
			return new String(data);
		} else {
			return null;
		}
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		TCPClient client = new TCPClient();
		
		// 连接
		client.connect("127.0.0.1", 8080);
		// 发消息
		client.sendMsg("你好啊");
		// 接收消息
		String receiveMsg = client.receiveMsg();
		System.out.println(receiveMsg);

	}
}
