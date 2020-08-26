package com.siping.数据库.mysql;

import java.sql.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author Xu.Yang
 * @date 2019/3/28 13 48
 * @desc:  测试mysql数据丢失
 */
public class LostUpdate implements Runnable {
    private CountDownLatch countDown;
    public LostUpdate(CountDownLatch countDown){
        this.countDown = countDown;
    }

    @Override
    public void run() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8",
                    "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            conn.setAutoCommit(false);
            //不加锁的情况
            //PreparedStatement ps =conn.prepareStatement("select * from lost_update where id =1");
            //加锁的情况
            PreparedStatement ps =conn.prepareStatement("select * from lost_update where id =1 for update");
            ResultSet rs=ps.executeQuery();
            int count = 0;
            while(rs.next()){
                count= rs.getInt("count");
            }

            count++;
            ps =conn.prepareStatement("update lost_update set count=? where id =1");
            ps.setInt(1, count);
            ps.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //表示一次任务完成
        countDown.countDown();
    }
}
