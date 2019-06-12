package com.siping.netty.聊天室.server;

import com.siping.netty.聊天室.MessageEncoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChatRoomServer {
    private final int port;

    public ChatRoomServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            // create ServerBootstrap instance
            ServerBootstrap b = new ServerBootstrap();
            // Specifies NIO transport, local socket address
            // Adds handler to channel pipeline
            b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).localAddress(port)
                .childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(new MessageEncoder(), new ServerTransferMsgHandler(), new ChatRoomServerHandler());
                }
            });

            // Binds server, waits for server to close, and releases resources
            ChannelFuture f = b.bind().sync();
            System.out.println(ChatRoomServer.class.getName() + "started and listen on “" + f.channel().localAddress());
            f.channel().closeFuture().sync();
        } finally {
        	bossGroup.shutdownGracefully().sync();
        	workGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new ChatRoomServer(65535).start();
    }
}
