package com.siping.netty.用户指南.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * timeserver
 * @author Xu.Yang
 * @date 2019/3/11 11 15
 * @desc: 提供了各种可以重写的事件处理程序方法 https://netty.io/wiki/user-guide-for-4.x.html
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当连接建立后调用该方法
     * @param ctx
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        /**
         * 要发送一个信息我们需要构建一个包含消息的缓冲区
         * 要发送一个32位的Integer，因此需要构建一个4个字节的字符流
         * ctx.alloc() 获取当前ByteBufAllocator，并分配新的缓冲区
         */
        final ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        /**
         * 编写构建好的信息
         * 写完成后如何得到通知？创建一个新的匿名内部类在操作玩成功关闭通道
         */
        final ChannelFuture f = ctx.writeAndFlush(time);
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
