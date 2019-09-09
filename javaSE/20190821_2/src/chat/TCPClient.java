package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
	//声明一个私有的客户端窗体类型的变量，因为我要访问这个窗体里面的文本框
	private ClientFrame clientFrame;
	public TCPClient(ClientFrame clientFrame){
		this.clientFrame=clientFrame;
	}


	/*
	 * 用于标识当前客户端是否与服务端保持连接 true:连接状态 false:断开状态
	 */
	private boolean isConnect;
	private Socket socket;

	/**
	 * 连接服务器
	 */
	public void connect() {
		try {
			//socket = new Socket(InetAddress.getByName("192.168.10.102"), 8989);
			socket = new Socket("192.168.20.126", 8989);
			System.out.println("连接服务器成功~~~");
			isConnect = true;
			// 读取服务器下推的消息
			MyClientReceiveThread receive = new MyClientReceiveThread(socket);
			receive.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接服务器失败~~~");
		}

	}

	/**
	 * 断开服务器
	 */
	public void disConnect() {
		try {
			socket.close();
			System.out.println("断开服务器成功~~~");
			isConnect = false;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("端开服务器失败~~~");
		}
	}

	//发送消息
	public void send(String msg) {
		if (isConnect == false) {
			return;
		}
		// 必须连接的状态下才发送消息
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			//显示到客户端文本域
			//LogUtils.showLog(msg, clientFrame.getTextArea());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*************************** getter and setter *******************/
	public boolean isConnect() {
		return isConnect;
	}

	public void setConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}

	// 成员内部类，得到服务端下推的消息
	class MyClientReceiveThread extends Thread {
		private Socket client;

		public MyClientReceiveThread(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			// 不断的读取服务器下推的消息
			DataInputStream dis;
			try {
				System.out.println("等待服务器下发数据。。。。");
				dis = new DataInputStream(client.getInputStream());
				while (true) {
					String msg = dis.readUTF();
					System.out.println("我是客户端，得到服务器下推的消息：" + msg);
					//把服务器下推的消息放入文本框
					LogUtils.showLog(msg, clientFrame.getTextArea());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
