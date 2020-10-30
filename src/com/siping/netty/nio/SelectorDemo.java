package com.siping.netty.nio;

import org.junit.Test;

import java.nio.channels.Selector;

/**
 * Selector（选择器）是JAVA NIO中能够检测一到多个NIO通道，并能知道是否诸如读写事件做好准备的组件。这样一个单独的线程可以管理多个Channel，从而管理
 * 多个网络连接。
 */
public class SelectorDemo {

    @Test
    public void test() {
        try {
            // Selector的创建
            Selector open = Selector.open();
            // 注册channel
            // channel.configureBlocking(false);
            // SelectionKey key = channel.register(selector, Selectionkey.OP_READ);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
