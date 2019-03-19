package com.siping.java基础.keywordFinal;

/**
 * 1.final成员变量
 *   类变量：必须要在静态初始化块中指定初始值或者声明该类变量时指定初始值，而且只能在这两个地方之一进行指定；
 *   实例变量：必要要在非静态初始化块，声明该实例变量或者在构造器中指定初始值，而且只能在这三个地方进行指定。
 * 2.final局部变量
 *   当final修饰基本数据类型变量时，不能对基本数据类型变量重新赋值，因此基本数据类型变量不能被改变。而对于引用类型变量而言，它仅仅保存的是一个引用，
 *   final只保证这个引用类型变量所引用的地址不会发生改变，即一直引用这个对象，但这个对象属性是可以改变的。
 * 3.final修饰方法
 *   1. 父类的final方法是不能够被子类重写的
 *   2. final方法是可以被重载的
 * 4.final类
 *    当一个类被final修饰时，表名该类是不能被子类继承的。子类继承往往可以重写父类的方法和改变父类属性，会带来一定的安全隐患，
 *    因此，当一个类不希望被继承时就可以使用final修饰。
 * 5.
 * @author Xu.Yang
 * @date 2019/3/18 15 17
 * @desc:
 */
public class FinalExample {
    private final int a = 6;
    private final String str;
    private final static boolean b;
    private final double c;

    {
        /**
         * 实例变量可以在初始化块中赋值
         */
        str = "初始化代码块";
    }

    static {
        /**
         * 类变量（静态变量）可以在静态初始化块中赋值，
         * 非静态变量不可以在静态初始化块中赋值
         */
        b = true;
    }

    public FinalExample() {

        c = 1.0;
        // 已经初始化了则不能再进行赋值
        // a = 10;
    }
}
