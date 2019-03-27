package com.siping.并发.并发编程实战.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Xu.Yang
 * @date 2019/3/26 15 48
 * @desc: ThreadLocal对象通常用于防止对可变的单实例或全局变量进行共享。例如，在单线程应用程序中可能会维持一个全局的数据库连接，并在程序启动时
 *        初始化这个连接对象，从而避免在调用每个方法时都要传一个Connection对象。
 *        当某个频繁执行的操作需要一个临时对象，例如一个缓冲区，而同时又希望避免在每次执行时都重新分配该临时对象，就可以使用ThreadLocal
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){
        public Connection initalValue() throws SQLException {
            return DriverManager.getConnection("DB_URL");
        }
    };

    public static Connection getConnectionHolder() {
        return connectionHolder.get();
    }
}
