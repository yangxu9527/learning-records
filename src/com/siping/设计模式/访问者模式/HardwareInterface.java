package com.siping.设计模式.访问者模式;

/**
 * @author Yang Xu
 * @date 2020/4/15 16:02
 * @description:
 */
public interface HardwareInterface {
    //定义了一些接口，访问硬件用的
    void visitor(CPU cpu);

    void visitor(VideoCard vCard);

    void visitor(HardDisk hd);
}
