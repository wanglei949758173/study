package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestServer {
	public static void main(String[] args) throws Exception {
		// 创建线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();

		ServerSocket serverSocket = null;
		try {
			// 创建ServerSocket
			serverSocket = new ServerSocket(6666);
			System.out.println("Server start...");

			while (true) {
				// 与客户端建立连接
				Socket socket = serverSocket.accept();
				System.out.println("client connect..");

				threadPool.execute(() -> {
					handleClientTask(socket);
				});
			}
		} finally {
			if (serverSocket != null) {
				serverSocket.close();
			}
		}
	}

	/**
	 * 处理客户端的任务
	 * 
	 * @param socket
	 *            套接字
	 */
	private static void handleClientTask(Socket socket) {
		InputStream inputStream = null;
		try {
			// 读取客户端发送的数据
			inputStream = socket.getInputStream();

			// 打印线程Id和Name
			Thread currentThread = Thread.currentThread();
			System.out.println("Thread ID：" + currentThread.getId() + "ThreadName："
					+ currentThread.getName());

			byte[] buffer = new byte[1024];
			while (true) {
				int read = inputStream.read(buffer);
				if (read != -1) {
					// 打印客户端发送的消息
					System.out.println("Client：" + new String(buffer, 0, read));
				} else {
					break;
				}
			}

			// 向客户端回执消息

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			try {
				socket.close();
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
