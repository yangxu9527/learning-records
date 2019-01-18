package com.siping.设计模式.代理模式.静态代理;

/**
 * @author Xu.Yang
 * @date 2019/1/18 11 13
 * @desc:
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
