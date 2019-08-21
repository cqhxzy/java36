package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.20.126",8989);
            System.out.println("与服务器建立连接成功");

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("hello world");

            buffer.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
