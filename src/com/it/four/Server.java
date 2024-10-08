package com.it.four;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 将客户端连接的socket对象分装为runnable对象并提交给线程池
public class Server {
    public static void main(String[] args) {
       //1、监听客户端ip和端口信息
        try {
            ServerSocket serverSocket = new ServerSocket(2222);
            //初始化线程池子
            HandelServerThreadPoll poll = new HandelServerThreadPoll(6,6,10);
            while (true) {
                System.out.println("服务端开始监听客户端的连接");
                Socket socket = serverSocket.accept();
                //将socket封装为runnable对象
                Runnable target = new ServerRunnabel(socket);
                //提交给线程池(注意：提交给线程池的时候才会执行runabel默认的run方法)
                poll.excute(target);
            }
        } catch (Exception  e) {
            throw new RuntimeException(e);
        }
    }
}
