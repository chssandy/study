package com.wicket.io.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter（规范）
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {
    //GlobalEventExecutor.INSTANCE 是全局事件执行器，是一个单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        Channel channel = ctx.channel();
        //将该客户加入聊天的信息推送给其他在线的客户端
        //该方法会将 channelGroup中所有的channel遍历，并发送消息
        channelGroup.writeAndFlush("[ 客户端 ]"+channel.remoteAddress() + "上线了" + sdf.format(new Date()));
        //将当前channel加入到 channelGroup
        channelGroup.add(channel);
        System.out.println(ctx.channel().remoteAddress()+"上线了" + "\n");
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx){
        Channel channel = ctx.channel();
        //将客户端离开信息推送给当前在线客户
        channelGroup.writeAndFlush("[ 客户端 ]"+channel.remoteAddress() +"下线了" +"\n");
        System.out.println(ctx.channel().remoteAddress()+"下线了"+"n");
        System.out.println("channelGroup size =" + channelGroup.size());

    }

    /***
     * 读取数据
     * @param ctx
     * @param s
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        //获取当前channel
        Channel channel = ctx.channel();
        //这时我们遍历 channelGroup，根据不同的情况，回送不同消息
        channelGroup.forEach(ch ->{
            if(channel != ch){
                //不是当前的channel，转发消息、
                ch.writeAndFlush("[ 客户端 ]" + channel.remoteAddress()+" 发送了消息：" +  s + "\n");
            }else{
                //回显自己发送的消息
                ch.writeAndFlush("[ 自己 ]发送了消息"+s + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        //关闭通道
        ctx.channel().close();
    }
}
