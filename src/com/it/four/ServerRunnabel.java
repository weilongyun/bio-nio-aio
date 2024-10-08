package com.it.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerRunnabel implements Runnable{
    public Socket socket;
    public ServerRunnabel(Socket socket) {
        System.out.println("ServerRunnabel init");
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            //4、将字符输入流封装成字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String msg ;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println(msg);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }

    }
}
