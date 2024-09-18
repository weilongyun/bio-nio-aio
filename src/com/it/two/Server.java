package com.it.two;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
//模拟的场景：多个客户端来连接服务端，服务端采用的还是单线程，第一个连接上来的可以和服务端正常通信
//第二个客户端连接会被服务端的ServerSocket挂起，连接不会报错，只不过不能和服务端进行通信，因为服务端与第一个客户端连接后进入while死循环了
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("服务端启动");
            //1、服务端的端口注册
            ServerSocket serverSocket = new ServerSocket(2222);
            //2、监听客户端的连接
            Socket socket = serverSocket.accept();
            //3、从socket中获取字节输入流
            InputStream inputStream = socket.getInputStream();
            //4、将字符输入流封装成字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg ;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println(msg);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

}
