/*      
 * 模块编号  
 * 功能描述 
 * 文件名 UDPClient.java  
 * 作者 王磊 
 * 编写日期 2019年3月7日    
 */
package test.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP客户端
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class UDPClient {
	/**
	 * 客户端套接字
	 */
	private DatagramSocket clientSocket = null;

	/**
	 * 服务器地址
	 */
	private InetSocketAddress serverAddress = null;

	public UDPClient(String serverIP, int serverPort) throws SocketException {
		clientSocket = new DatagramSocket(0);
		serverAddress = new InetSocketAddress(serverIP, serverPort);
	}

	/**
	 * 发送消息
	 * @param msg 消息
	 * @throws IOException 
	 */
	public void send(String msg) throws IOException {
		byte[] data;
		try {
			data = msg.getBytes("utf-8");
			DatagramPacket packet =
					new DatagramPacket(data, data.length, serverAddress);
			clientSocket.send(packet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 接收消息
	 * @return 接收到的消息
	 * @throws IOException 
	 */
	public String receive() throws IOException {
		DatagramPacket response = new DatagramPacket(new byte[1024], 1024, serverAddress);
		clientSocket.receive(response);
		String result;
		try {
			result = new String(response.getData(), 0, response.getLength(),"utf-8");
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		try (DatagramSocket socket = new DatagramSocket(0)) {
			UDPClient client = new UDPClient("127.0.0.1", 8080);
			client.send("你好啊，服务器");
			String result = client.receive();
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
