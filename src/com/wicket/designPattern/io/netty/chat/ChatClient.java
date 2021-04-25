package com.wicket.io.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        //客户端需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            //创建客户端启动对象
            //注意客户端使用的不是ServerBootStrap而是BootStrap
            Bootstrap bootstrap = new Bootstrap();
            //设置相关参数
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>(){ //创建通道初始化对象，设置初始化参数
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //对workerGroup的SocketChannel设置处理器
                            socketChannel.pipeline().addLast(new ChatClientHandler());
                        }
                    });
            System.out.println("netty client start...");
            //启动客户端去连接服务端
            ChannelFuture cf = bootstrap.connect("127.0.0.1",9000).sync();
            //得到channel
            Channel channel = cf.channel();
            System.out.println("========================"+channel.localAddress()+"======================");
            //客户端需要输入，创建一个扫描器
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                String msg = scanner.nextLine();
                //通过channel 将msg发送到服务器端
                channel.writeAndFlush(msg);
            }
            //对通道关闭进行监听
            channel.closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }

    }
}
