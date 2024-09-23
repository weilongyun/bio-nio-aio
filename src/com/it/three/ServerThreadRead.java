package com.it.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadRead  extends Thread {
    private Socket socket;
    public ServerThreadRead(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //获取字节输入流
            InputStream inputStream = socket.getInputStream();
            //字节输入流转为字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String msg;
            while((msg = bufferedReader.readLine()) != null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
