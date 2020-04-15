package com.siping.设计模式.访问者模式;

/**
 * @author Yang Xu
 * @date 2020/4/15 16:03
 * @description:
 */
public class CPU extends ComputerPart {
    @Override
    protected void link(HardwareInterface hardwareInterface) {
        // 先得通过接口连接数据
        hardwareInterface.visitor(this);
        // 连接完了之后，就开始使用cpu
        System.out.println("连接上了之后，利用cpu进行计算数据");
    }
}
