package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ChatServer {

    private static Vector<Socket> list = new Vector<>();


    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8989);
            System.out.println("服务端创建成功");

            //服务端开始等待客户端的连接

            while (true) {
                Socket accept = serverSocket.accept(); //连接到服务端的Socket
                System.out.println("捕获到客户端发起的请求。。。");
                list.addElement(accept);
                new Thread(new ServerThread(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerThread implements Runnable {
        private Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                while (true) {//得到具体某个客户端发送到服务器的消息

                    String msg = getMsg(inputStream);//获取客户端发送的消息
                    System.out.println("服务端接收到客户端消息：" + msg);
                    sendMsg(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从输入流中获取消息
     * @param inputStream
     * @return
     */
    private static String getMsg(InputStream inputStream){
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            return dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将消息推送到客户端
     * @param msg
     */
    private static void sendMsg(String msg){
        System.out.println("服务端开始向客户端推送消息:" + msg);
        for (Socket socket : list) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
