package com.siping.netty.demoRpc.provider;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Xu.Yang
 * @date 2019/3/11 13 51
 * @desc:
 */
public class HelloServer {
    private int port;

    public HelloServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        /**
         * bossGroup 负责tcp的三次握手，socketChannel建立
         * workerGroup 负责消息读写，编码解码
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            /**
             * 可以设置服务器的帮助类
             */
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    /**
                     * 实例化一个通道接收传入的连接
                     */
                    .channel(NioServerSocketChannel.class)
                    /**
                     * 指定channel
                     */
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new StringDecoder());
                            p.addLast(new StringEncoder());
                            p.addLast(new HelloServerHandler());
                        }
                    });
                    /**
                     * 对应操作系统中的ChannelOption
                     */
                    //.option(ChannelOption.SO_BACKLOG, 128)
                    /**
                     * option主要是设置的ServerChannel的一些选项，而childOption主要是设置的ServerChannel的子Channel的选项。
                     * 如果是Bootstrap的话，只会有option而没有childOption，所以设置的是客户端Channel的选项。
                     */
                    //.childOption(ChannelOption.SO_KEEPALIVE, true);

            /**
             * 绑定端口并等待连接
             */
             b.bind(port).sync();

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            //f.channel().closeFuture().sync();
        } finally {
            //workerGroup.shutdownGracefully();
            //bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8088;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new HelloServer(port).run();
    }
}
