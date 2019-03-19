package com.siping.netty.demoRpc.consumer;

import com.siping.netty.demoRpc.publicInterface.HelloService;

/**
 * @author Xu.Yang
 * @date 2019/3/13 15 15
 * @desc:
 */
public class ClientTest {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {
        RpcConsumer consumer = new RpcConsumer();
        // 创建一个代理对象
        HelloService service = (HelloService) consumer
                .createProxy(HelloService.class, providerName);
        while (true) {
            System.out.println(service.hello("are you ok ?"));
            Thread.sleep(1000);
        }
    }
}
