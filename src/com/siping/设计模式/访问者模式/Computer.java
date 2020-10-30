package com.siping.设计模式.访问者模式;

/**
 * @author Yang Xu
 * @date 2020/4/15 16:06
 * @description:
 */
public class Computer {
    /**
     * 电脑的类，当需要装机的话，就先准备好硬件，即new出来，然后插上接口
     *
     * @param hardwareInterface
     */
    public void useComputer(HardwareInterface hardwareInterface) {

        //通过接口，连接cpu
        new CPU().link(hardwareInterface);
        //通过接口，连接显卡
        new VideoCard().link(hardwareInterface);
        //通过接口连接硬盘
        new HardDisk().link(hardwareInterface);

    }
}
