package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static List<Socket> list = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8989);

            System.out.println("服务端创建成功");

            //服务端开始等待客户端的连接

            while (true) {
                Socket accept = serverSocket.accept(); //连接到服务端的Socket
                System.out.println("捕获到客户端发起的请求。。。");

                list.add(accept);

                //服务端获取客户端的数据
                InputStream inputStream = accept.getInputStream();

                //将字节流转换为字符流
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader buffer = new BufferedReader(isr);

                StringBuilder builder = new StringBuilder();
                String str;
                while ((str = buffer.readLine()) != null) {
                    builder.append(str); //将字符串拼接到StringBuilder
                    builder.append("\r\n"); //将字符串拼接到StringBuilder
                }

                System.out.println("客户端说：" + builder.toString());
                buffer.close();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
