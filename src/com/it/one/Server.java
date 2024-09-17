package com.it.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
//单发单收单情况
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("服务端启动");
            //1、服务端的端口注册
            ServerSocket serverSocket = new ServerSocket(2222);
            //2、监听客户端的连接
            Socket socket = serverSocket.accept();
            socket.setSoTimeout(5000);
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
