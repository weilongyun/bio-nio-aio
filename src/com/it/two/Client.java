package com.it.two;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //1、创建socket连接服务端
        Socket socket = new Socket("127.0.0.1",2222);
        //2、获取字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //3、字节输出流转为字符打印输出流(按行打印)
        PrintStream printStream = new PrintStream(outputStream);
        while (true){
            System.out.print("请说:");
            String msg = new Scanner(System.in).nextLine();
            printStream.println(msg);
            printStream.flush();
        }
    }
}
