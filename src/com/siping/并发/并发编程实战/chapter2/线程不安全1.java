package com.siping.并发.并发编程实战.chapter2;

import com.siping.并发.并发编程实战.provider.Servlet;
import com.siping.并发.并发编程实战.provider.ServletRequest;
import com.siping.并发.并发编程实战.provider.ServletResponse;

import java.math.BigInteger;

/**
 * @author Xu.Yang
 * @date 2019/3/5 16 28
 * @desc: 该类为线程不安全的类。该类的功能为每处理一个请求就+1.++count包含，读取、修改、写入的操作，并不是原子操作
 */
public class 线程不安全1 implements Servlet {

    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
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
