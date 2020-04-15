package com.siping.设计模式.访问者模式;

/**
 * @author Yang Xu
 * @date 2020/4/15 16:29
 * @description:
 */
public class Test {

    public static void main(String[] args) {

        //想要装机，先得装电脑的架子
        Computer computer = new Computer();
        //有架子后，就想着用什么接口去装电脑，这里是用usb接口去连接里面的硬件的。当然，也可以去换成其他接口
        computer.useComputer(new USBInterface());
    }
}
