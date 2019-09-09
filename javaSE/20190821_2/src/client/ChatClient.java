package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static Socket socket = null;
    private static final String ADDRESS = "192.168.20.126";
    private static final int PORT = 8989;

    public static void main(String[] args) {
        System.out.println("欢迎使用MyChat聊天系统");
        System.out.println("1.加入聊天室");
        Scanner input = new Scanner(System.in);



        int nextInt = input.nextInt();
        if (nextInt == 1) {
            join();
            System.out.println("加入聊天室成功！");

            //开启一个线程用于接收服务端推送的消息
            new Thread(new ChatThread(socket)).start();

            while (true) {
                System.out.println("1.发言   2.退出聊天室");
                nextInt = input.nextInt();
                if (nextInt == 1) { //发言
                    System.out.println("请输入聊天内容：");
                    String msg = input.next();
                    sendMsg(msg);
                } else { //退出
                    System.out.println("退出聊天室");
                    quit();
                    break;
                }
            }



        }
    }

    private static void join(){
        try {
            socket = new Socket(ADDRESS, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void quit(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向服务端发送消息
     * @param msg
     */
    private static void sendMsg(String msg) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class ChatThread implements Runnable{
        private Socket socket;

        public ChatThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();

                while (true) {
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    String s = dataInputStream.readUTF();
                    System.out.println("接收到服务端消息：" + s);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
