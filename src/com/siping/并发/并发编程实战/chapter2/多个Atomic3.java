package com.siping.并发.并发编程实战.chapter2;

import com.siping.并发.并发编程实战.provider.Servlet;
import com.siping.并发.并发编程实战.provider.ServletRequest;
import com.siping.并发.并发编程实战.provider.ServletResponse;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Xu.Yang
 * @date 2019/3/5 17 20
 * @desc: 该线程不安全。假如需要提升性能将最近因数分解的结果缓存起来，当两个连续的请求对相同的因数数值进行因数分解时进行缓存。
 * 如果需要使线程安全可以考虑使用synchronized(内置锁)锁定service方法，但这样会造成性能的问题
 */
public class 多个Atomic3 implements Servlet {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();


    @Override
    public void service(ServletRequest req, ServletResponse res) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(res, lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(res, lastFactors.get());
        }
    }

    /**
     * 分解后的因数写入到response
     *
     * @param res
     * @param factors
     */
    private void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {

    }

    /**
     * 从请求中提取因数
     *
     * @param req
     * @return
     */
    private BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("1");
    }

    /**
     * 因数分解
     *
     * @param i
     * @return
     */
    private BigInteger[] factor(BigInteger i) {

        return new BigInteger[1];
    }
}
