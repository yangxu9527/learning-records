package com.siping.netty.聊天室.session;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

public class IoSession {

    private Channel channel;
    private User user;

    /**
     * ip地址
     */
    private String ipAddr;

    private boolean reconnected;

    /**
     * 拓展用，保存一些个人数据
     */
    private Map<String, Object> attrs = new HashMap<>();

    public IoSession() {

    }

    public IoSession(Channel channel) {
        this.channel = channel;
        this.ipAddr = ChannelUtils.getIp(channel);
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 向客户端发送消息
     *
     * @param packet
     */
    public void sendPacket(String packet) {
        if (packet == null) {
            return;
        }
        if (channel != null) {
            channel.writeAndFlush(packet);
        }
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public boolean isReconnected() {
        return reconnected;
    }

    public void setReconnected(boolean reconnected) {
        this.reconnected = reconnected;
    }

    public User getUser() {
        return user;
    }

    public boolean isClose() {
        if (channel == null) {
            return true;
        }
        return !channel.isActive() ||
                !channel.isOpen();
    }

    /**
     * 关闭session
     */
    public void close(SessionCloseReason reason) {
        try {
            if (this.channel == null) {
                return;
            }
            if (channel.isOpen()) {
                channel.close();
            } else {

            }
        } catch (Exception e) {
        }
    }
}
