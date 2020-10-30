package com.siping.设计模式.代理模式.Cglib动态代理;

import com.siping.设计模式.代理模式.JDK动态代理.ProxyFactory;
import org.junit.Test;

/**
 * @author Xu.Yang
 * @date 2019/1/18 11 16
 * @desc:
 */
public class ProxyTest {

    @Test
    public void test() {
        //目标对象
        UserDao target = new UserDao();
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.save();
    }
}
