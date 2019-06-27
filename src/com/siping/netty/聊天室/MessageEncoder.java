package com.siping.netty.聊天室;

import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 *
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {

	@Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        String content = Utils.encodeMsg(message);
        buffer.writeBytes(content.getBytes(StandardCharsets.UTF_8));

        ctx.writeAndFlush(buffer);
    }
}
