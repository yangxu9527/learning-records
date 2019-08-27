package com.siping.netty.聊天室.session;

import com.sun.xml.internal.ws.api.message.Packet;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum  ServerManager {
    INSTANCE;


    /** 缓存通信上下文环境对应的登录用户（主要用于服务） */
    private Map<IoSession, Long> session2UserIds  = new ConcurrentHashMap<>();

    /** 缓存用户id与对应的会话 */
    private ConcurrentMap<Long, IoSession> userId2Sessions = new ConcurrentHashMap<>();


    public void sendPacketTo(String pact, Long userId){
        if(pact == null || userId <= 0) return;

        IoSession session = userId2Sessions.get(userId);
        if (session != null) {
            session.sendPacket(pact);
        }
    }

    /**
     *  向所有在线用户发送数据包
     */
    public void sendPacketToAllUsers(String pact){
        if(pact == null ) {
            return;
        }

        userId2Sessions.values().forEach( (session) -> session.sendPacket(pact));
    }

    /**
     *  向单一在线用户发送数据包
     */
    public void sendPacketTo(Packet pact, ChannelHandlerContext targetContext ){
        if(pact == null || targetContext == null) return;
        targetContext.writeAndFlush(pact);
    }


    public IoSession getSessionBy(long userId) {
        return this.userId2Sessions.get(userId);
    }

    public boolean registerSession(User user, IoSession session) {

        session.setUser(user);
        userId2Sessions.put(user.getUserId(), session);


        return true;
    }

    /**
     *   注销用户通信渠道
     */
    public void ungisterUserContext(Channel context ){
        if(context  == null){

            return;
        }
        IoSession session = ChannelUtils.getSessionBy(context);
        Long userId = session2UserIds.remove(session);
        userId2Sessions.remove(userId);
        if (session != null) {
            session.close(SessionCloseReason.OVER_TIME);
        }
    }
}
