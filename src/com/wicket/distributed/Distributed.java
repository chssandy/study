package com.wicket.distributed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Distributed
 * @description TODO
 * @date 2020/9/27 11:20
 */
public class Distributed {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        //创建连接
        Socket socket = new Socket("127.0.0.1",8080);
        //创建读取服务器端返回流的BufferedReader
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        //创建服务器写入流的PrintWriter
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        //向服务器发送字符串信息，要注意的是，此处及时写失败也不会抛出异常信息，并且一直会阻塞到写入操作系统或者网络IO出现异常为止
        out.println("hello");
        //阻塞读取服务端的返回信息
        in.readLine();


        //服务器端关键代码如下
        ServerSocket ss = new ServerSocket(8080);
        Socket socket1 = ss.accept();


        //TCP/IP+NIO
        SocketChannel channel = SocketChannel.open();
        //设置为非阻塞模式
        channel.configureBlocking(false);
        //对于非阻塞模式，like返回false，表示连接正在建立中
        channel.connect(SocketAddress.class.newInstance());
        Selector selector = Selector.open();
        //向channel注册selector以及感兴趣的连接事件
        channel.register(selector, SelectionKey.OP_CONNECT);

    }
}
