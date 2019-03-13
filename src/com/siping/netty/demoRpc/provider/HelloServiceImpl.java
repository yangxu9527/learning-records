package com.siping.netty.demoRpc.provider;

import com.siping.netty.demoRpc.publicInterface.HelloService;

/**
 * @author Xu.Yang
 * @date 2019/3/13 09 25
 * @desc:
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        return msg != null ? msg + " -----> I am fine." : "I am fine.";
    }
}
