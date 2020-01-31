/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Server.java  
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
import java.util.HashMap;
import java.util.Map;

/**
 * UDP服务类
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class UDPServer {
	/**
	 * 服务器套接字
	 */
	private DatagramSocket socket = null;

	public UDPServer(int serverPort) throws SocketException {
		socket = new DatagramSocket(serverPort);
	}

	/**
	 * 接收消息
	 * @return 接收到的消息
	 * @throws IOException
	 */
	public Map<String, String> receive() throws IOException {
		Map<String, String> map = new HashMap<>();
		DatagramPacket clientPacket = new DatagramPacket(new byte[1024], 1024);
		socket.receive(clientPacket);
		byte[] data = clientPacket.getData();
		String result = new String(data, 0, clientPacket.getLength(), "utf-8");

		map.put("ip", clientPacket.getAddress().getHostAddress());
		map.put("port", clientPacket.getPort() + "");
		map.put("result", result);
		return map;
	}

	/**
	 * 发送消息
	 * @param msg 消息
	 * @throws IOException 
	 */
	public void send(String msg, String sendIp, int sendPort)
			throws IOException {
		byte[] data;
		try {
			data = msg.getBytes("utf-8");
			DatagramPacket packet =
					new DatagramPacket(data,
							data.length,
							new InetSocketAddress(sendIp, sendPort));
			socket.send(packet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			UDPServer server = new UDPServer(8080);
			while (true) {
				Map<String, String> receive = server.receive();
				System.out.println(receive.get("ip") + ":" + receive.get("port") + "：" + receive.get("result"));
				String msg = "我接收到了你发的消息：“" + receive.get("result") + "“";
				server.send(msg, receive.get("ip"), Integer.parseInt(receive.get("port")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
