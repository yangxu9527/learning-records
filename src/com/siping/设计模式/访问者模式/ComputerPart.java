package com.siping.设计模式.访问者模式;

/**
 * @author Yang Xu
 * @date 2020/4/15 15:59
 * @description:
 */
public abstract class ComputerPart {
    /**
     * 所有的 零配件，都必须通过一个硬件接口进行连接
     * @param hardwareInterface
     */
    protected abstract void link(HardwareInterface hardwareInterface);
}
