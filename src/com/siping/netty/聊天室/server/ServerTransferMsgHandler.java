package com.siping.netty.聊天室.server;

import java.nio.charset.Charset;
import java.util.List;

import com.siping.netty.聊天室.Message;
import com.siping.netty.聊天室.Utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 解码器
 * @author Wei-Ping
 *
 */
public class ServerTransferMsgHandler extends ByteToMessageDecoder {
	@Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        String totalMsg = in.readCharSequence(in.readableBytes(), Charset.forName("utf-8")).toString();
        String[] content = totalMsg.split("~");
        out.add(new Message(content[0], Utils.parseDateTime(content[1]), content[2]));
    }
}
