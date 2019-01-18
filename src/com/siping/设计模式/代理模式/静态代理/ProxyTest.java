package com.siping.设计模式.代理模式.静态代理;

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
        IUserDao target = new UserDao();
        IUserDao proxy = new UserDaoProxy(target);
        proxy.save();
    }

    @Test
    public void jdkTest() {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(target.getClass());
        proxy.save();
    }
}
