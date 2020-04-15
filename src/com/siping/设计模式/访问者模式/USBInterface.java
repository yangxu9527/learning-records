package com.siping.设计模式.访问者模式;

/**
 * @author Yang Xu
 * @date 2020/4/15 16:28
 * @description:
 */
public class USBInterface implements HardwareInterface {
    @Override
    public void visitor(CPU cpu) {
        System.out.println("usb连接cpu");
    }

    @Override
    public void visitor(VideoCard vCard) {
        System.out.println("用usb连接显卡");
    }

    @Override
    public void visitor(HardDisk hd) {
        System.out.println("用usb连接硬盘");
    }
}
