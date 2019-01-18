package com.siping.设计模式.代理模式.静态代理;

/**
 * @author Xu.Yang
 * @date 2019/1/18 11 14
 * @desc:
 */
public class UserDaoProxy implements IUserDao {
    /**
     * 接收保存目标对象
     */
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
