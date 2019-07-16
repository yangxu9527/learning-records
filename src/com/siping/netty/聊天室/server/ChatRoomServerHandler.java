package com.siping.netty.聊天室.server;

import java.util.Date;
import java.util.Scanner;

import com.siping.netty.聊天室.Constants;
import com.siping.netty.聊天室.Message;
import com.siping.netty.聊天室.Utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;

public class ChatRoomServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 保存会话数据
     */
    private AttributeKey<Integer> key = AttributeKey.valueOf("test");

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("jsbintask-client进入聊天室。");
        Message message = new Message(Constants.SERVER, new Date(), "Hello, I'm jsbintask-server side.");
        ByteBuf buffer = ctx.alloc().buffer();
        String content = Utils.encodeMsg(message);
        buffer.writeBytes(content.getBytes());

        ctx.writeAndFlush(buffer);
	}
	
	/**
	 * 客户端连接后
	 */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client registered : " + ctx.name());
    }
    
    /**
     * 接收到消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg1) throws Exception {
        Attribute<Integer> attr = ctx.channel().attr(key);
        if (attr.get() == null) {
            attr.set(1);
        }else {
            attr.set((attr.get() + 1));
        }
        try {
            Message msg = (Message) msg1;
            System.out.println("第[" + attr.get() + "]次接收到消息");
            Utils.printMsg(msg);
            Scanner scanner = new Scanner(System.in);
            System.out.print("jsbintask-server, please input msg: ");
            String reply = scanner.nextLine();


            Message message = new Message(Constants.SERVER, new Date(), reply);
            ctx.writeAndFlush(message);
        } finally {
            ReferenceCountUtil.release(msg1);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        //ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }
    
    /**捕获异常*/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
