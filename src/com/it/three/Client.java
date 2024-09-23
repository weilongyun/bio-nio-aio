package com.it.three;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建socket连接
        Socket socket = new Socket("127.0.0.1",2222);
        // 获取字节输出流
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        String msg ;
        while (true){
            System.out.print("请说:");
            msg = new Scanner(System.in).nextLine();
            printStream.println(msg);
            printStream.flush();
        }

    }
}
