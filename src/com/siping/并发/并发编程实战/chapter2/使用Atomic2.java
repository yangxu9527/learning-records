package com.siping.并发.并发编程实战.chapter2;

import com.siping.并发.并发编程实战.provider.Servlet;
import com.siping.并发.并发编程实战.provider.ServletRequest;
import com.siping.并发.并发编程实战.provider.ServletResponse;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Xu.Yang
 * @date 2019/3/5 17 13
 * @desc: 这是线程安全的，使用原子类来进行操作，先检查后修改，保证读取、修改、写入是原子的。
 *        虽然在该例子中使用atomic是线程安全的，但如果有多个atomic成员变量则不一定是线程安全的
 */
public class 使用Atomic2 implements Servlet {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(res, factors);
    }

    /**
     * 分解后的因数写入到response
     * @param res
     * @param factors
     */
    private void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {

    }

    /**
     * 从请求中提取因数
     * @param req
     * @return
     */
    private BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("1");
    }

    /**
     * 因数分解
     * @param i
     * @return
     */
    private BigInteger[] factor(BigInteger i) {

        return new BigInteger[1];
    }
}
