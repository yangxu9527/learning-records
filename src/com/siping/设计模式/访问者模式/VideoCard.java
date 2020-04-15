package com.siping.设计模式.访问者模式;

/**
 * @author Yang Xu
 * @date 2020/4/15 16:03
 * @description: 电脑硬件之显卡 通过显卡可以进行电脑的屏幕图像的显示
 */
public class VideoCard extends ComputerPart {
    @Override
    protected void link(HardwareInterface hardwareInterface) {
        // 先得通过接口连接数据
        hardwareInterface.visitor(this);
        // 连接完了之后，就开始使用cpu
        System.out.println("连接上显卡之后，显卡开始工作，提供图像");
    }
}
