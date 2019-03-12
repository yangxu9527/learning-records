package com.siping.netty.用户指南.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Xu.Yang
 * @date 2019/3/12 14 30
 * @desc:
 */
public class TimeClient {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 8080;
       /* String host = args[0];
        int port = Integer.parseInt(args[1]);*/
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            /**
             * 类似于ServerBootstrap，不同是它用于客户端通道
             */
            Bootstrap b = new Bootstrap();
            /**
             * 客户端只需要一个worker线程
             */
            b.group(workerGroup);
            /**
             * NioSocketChannel创建客户端通道
             */
            b.channel(NioSocketChannel.class);
            /**
             * 客户端不像服务端，它没有childOption
             */
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });

            /**
             * 连接服务器
             */
            ChannelFuture f = b.connect(host, port).sync();

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
