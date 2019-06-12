package com.siping.netty.client;

import java.nio.charset.Charset;
import java.util.Date;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	/**
	 * 客户端连接后不断向服务器发送消息
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buffer = getByteBuf("你好，服务器！",ctx);
        ctx.channel().writeAndFlush(buffer);
		//ctx.write(Unpooled.copiedBuffer("Netty  rocks!", CharsetUtil.UTF_8));
	}
	private ByteBuf getByteBuf(String msg, ChannelHandlerContext ctx) {
        byte[] bytes = msg.getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        
        return buffer;
    }
	
	/**
	 * 客户端收到服务端消息
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		//System.out.println("Client  received:  " + ByteBufUtil.hexDump(msg.readBytes(msg.readableBytes())));
		ByteBuf byteBuf = (ByteBuf) msg;
		System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
