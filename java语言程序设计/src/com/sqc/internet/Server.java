package com.sqc.internet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.创建客户端连接
        Socket socket = serverSocket.accept();
        System.out.println("一个客户端建立连接");
//        3.发送数据
        String msg = "欢迎使用";
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(msg);
        dataOutputStream.flush();

    }
}
