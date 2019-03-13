package com.siping.netty.demoRpc.consumer;

import com.siping.netty.用户指南.time.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Xu.Yang
 * @date 2019/3/13 12 15
 * @desc:
 */
public class RpcConsumer {

    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static HelloClientHandler client;

    /**
     * 创建一个代理对象
     */
    public Object createProxy(final Class<?> serviceClass,
                              final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serviceClass}, (proxy, method, args) -> {
                    if (client == null) {
                        initClient();
                    }
                    // 设置参数
                    client.setPara(providerName + args[0]);
                    return executor.submit(client).get();
                });
    }

    /**
     * 初始化客户端
     */
    private static void initClient() {
        client = new HelloClientHandler();
        String host = "127.0.0.1";
        int port = 8080;
       /* String host = args[0];
        int port = Integer.parseInt(args[1]);*/
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.TCP_NODELAY, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline p = ch.pipeline();
                    p.addLast(new StringDecoder());
                    p.addLast(new StringEncoder());
                    p.addLast(client);
                }
            });

            /**
             * 连接服务器
             */
            ChannelFuture f = b.connect(host, port).sync();

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
            workerGroup.shutdownGracefully();
        }*/
    }
}
