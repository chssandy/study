package com.wicket.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SocketMultiplexingSingleThreadv1 {
    // java使用多路复用器，多路复用器其实是kernel提供的，种类很多，那么java的selector如何包装的尼？

    private ServerSocketChannel server = null;
    private Selector selector = null;
    int port = 9999;

    public void initServer(){
        try{
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));


            server.register(selector,SelectionKey.OP_ACCEPT);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
