package com.it.three;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//通过创建多线程的方式处理接收多个客户端的请求
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("服务端启动，并准备接收客户端的连接");
            ServerSocket serverSocket = new ServerSocket(2222);
            while (true) {
                //每接收一个客户端的连接请求服务端都会创建一个线程并交给改线程进行处理
                Socket socket = serverSocket.accept();
                System.out.println("服务端已经连接了一个客户端并创建一个新的线程");
                //交给一个新的线程去处理
                new ServerThreadRead(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
