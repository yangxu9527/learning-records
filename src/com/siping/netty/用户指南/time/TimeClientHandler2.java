package com.siping.netty.用户指南.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 *      在基于流的传输(如TCP/IP )中，接收到的数据存储在套接字接收缓冲区中。但是，基于流的传输的缓冲区不是数据包队列，而是字节队列。
 * 这意味着，即使您将两个消息作为两个独立的数据包发送，操作系统也不会将它们视为两个消息，而只是一堆字节。因此，不能保证您所读的正是您的远程对等方所写的。
 * 例如，让我们假设操作系统的TCP/IP堆栈已经接收到三个数据包: ABC DEF GHI。有可能变成AB CDEFG HI
 * 第一种解决方案：32位整数是非常少量的数据，不太可能经常被分段。但是，问题是它可能是碎片化的，碎片化的可能性会随着流量的增加而增加。
 *       简单的解决方案是创建一个内部累积缓冲区，并等到所有4个字节都被接收到内部缓冲区
 * @author Xu.Yang
 * @date 2019/3/12 14 31
 * @desc:
 */
public class TimeClientHandler2 extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        buf = ctx.alloc().buffer(4); // (1)
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        buf.release(); // (1)
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg;
        buf.writeBytes(m); // (2)
        m.release();

        if (buf.readableBytes() >= 4) { // (3)
            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
