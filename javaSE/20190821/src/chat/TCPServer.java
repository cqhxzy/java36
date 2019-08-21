package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class TCPServer {

	// 声明一个服务器端的窗体对象，因为我想要访问这个窗体里面的文本框
	private ServerFrame serverFrame;

	public TCPServer(ServerFrame serverFrame) {
		this.serverFrame = serverFrame;
	}

	// 添加一个属性，关于客户端线程的列表，记录每个客户端
	private Vector<MyClientThread> clientlist = new Vector<>();

	/*
	 * 用于标识服务器监听是否已经启动 true:服务器处于启动监听状态 false:服务器监听处于关闭状态
	 */
	private boolean isStart;
	private ServerSocket server;

	/**
	 * 启动监听
	 */
	public void startListener() {
		try {
			server = new ServerSocket(8989); //实例化服务端
			System.out.println("启动监听成功~~~");
			isStart = true; //服务端已经启动
			// 把一直等待客户端的连接的accept 方法开启一条线程
			StartAcceptThread acceptThread = new StartAcceptThread();
			acceptThread.start();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("启动监听失败~~~");
			return;
		}

	}

	/**
	 * 停止监听
	 */
	public void stopListener() {
		try {
			server.close();
			System.out.println("停止监听成功~~~");
			isStart = false;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("停止监听失败~~~");
		}
	}

	/************************ getter and setter ***********************/
	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	// 监听accept线程 -- 成员内部类
	class StartAcceptThread extends Thread {
		@Override
		public void run() {
			while (true) {
				if (server.isClosed()) {//如果服务器已经关闭，则结束线程
					return;
				}
				try {
					Socket socket = server.accept();
					// 再开一条线程用于接受客户端消息，并下发给每个客户端去
					MyClientThread clients = new MyClientThread(socket);
					clients.start();
					// 往集合里面加数据，该集合是关于客户端线程的列表，记录每个客户端
					clientlist.addElement(clients);
					LogUtils.showLog("在线人数是："+clientlist.size(), serverFrame.getTextArea());

				} catch (IOException e) {
					e.printStackTrace();

				}

			}
		}
	}

	// 服务端使用的，专门与一个客户端对话的线程----成员内部类
	class MyClientThread extends Thread {
		private Socket client;

		public MyClientThread(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			// 获取读取和写入对象
			try {
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				while (true) {
					// 接受每一个在线用户的消息
					String message = dis.readUTF(); //阻塞，等待接收用户输入数据
					System.out.println("这是服务端，客户端发来消息---" + message);

					// 接受的客户端消息，写入文本框
					LogUtils.showLog(message, serverFrame.getTextArea());

					// 往客户端下推消息
					//dos.writeUTF("响应：" + message);
					//循环下推给每一个客户端
					for (MyClientThread mc : clientlist) {
						System.out.println("-----------------");
						mc.serverSend(message);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("读取客户端信息失败，客户端可能已经断开！");
				LogUtils.showLog("读取客户端信息失败，客户端可能已经断开", serverFrame.getTextArea());
				clientlist.remove(this);
				LogUtils.showLog("当前客户端人数："+clientlist.size(), serverFrame.getTextArea());

			}
		}
		/**
		 * 服务端往下推的方法
		 * @param msg
		 */
		public void serverSend(String msg){
			try {
				DataOutputStream dos=new DataOutputStream(client.getOutputStream());
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}
}
