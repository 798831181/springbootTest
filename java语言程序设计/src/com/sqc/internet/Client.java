package com.sqc.internet;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
//        1.创建客户端 指定服务器和端口
        Socket client = new Socket("localhost", 8888);
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String s = dataInputStream.readUTF();
        System.out.println(s);
    }
}
