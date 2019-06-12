package com.siping.netty.聊天室.client;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

import com.siping.netty.聊天室.Constants;
import com.siping.netty.聊天室.Message;
import com.siping.netty.聊天室.Utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

public class ChatRoomClientHandler extends SimpleChannelInboundHandler<Message> {

	/**
	 * 客户端连接后不断向服务器发送消息
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}
	
	/**
	 * 客户端收到服务端消息
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		try {
            Utils.printMsg(msg);
            Scanner scanner = new Scanner(System.in);
            System.out.print("jsbintask-client, please input msg: ");
            String reply = scanner.nextLine();

            Message message = new Message(Constants.CLIENT, new Date(), reply);
            ByteBuf buffer = ctx.alloc().buffer();
            String content = message.getUsername() + "~" + Utils.formatDateTime(message.getSentTime()) + "~" + message.getMsg();
            buffer.writeBytes(content.getBytes(StandardCharsets.UTF_8));
            ctx.writeAndFlush(buffer);
        } finally {
            ReferenceCountUtil.release(msg);
        }
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
