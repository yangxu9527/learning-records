package com.siping.netty.用户指南.discard;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * discard协议：最简单的协议，接收什么就丢掉什么
 *
 * @author Xu.Yang
 * @date 2019/3/11 11 15
 * @desc: 提供了各种可以重写的事件处理程序方法
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 从客户端接收数据
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        // Discard the received data silently.
        /**
         * 1.打印消息
         */
        /*ByteBuf in = (ByteBuf) msg;
        try {
            *//*while (in.isReadable()) {
                System.out.print((char) in.readByte());
                System.out.flush();
            }*//*
            System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
        } finally {
            ReferenceCountUtil.release(msg);
        }*/
        /**
         * 2.响应消息
         */
        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
