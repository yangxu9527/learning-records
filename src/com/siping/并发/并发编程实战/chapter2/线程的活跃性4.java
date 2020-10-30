package com.siping.并发.并发编程实战.chapter2;

import com.siping.并发.并发编程实战.provider.Servlet;
import com.siping.并发.并发编程实战.provider.ServletRequest;
import com.siping.并发.并发编程实战.provider.ServletResponse;

import java.math.BigInteger;

/**
 * @author Xu.Yang
 * @date 2019/3/6 11 09
 * @desc: 在例子3中直接可以使用synchronized(内置锁)锁定service方法来解决线程安全问题，但是这样会带来一个问题就是性能问题。因此我们这里拆掉，
 * 只对关键的代码上锁。
 * 注：本例增加了缓存命中的需求
 */
public class 线程的活跃性4 implements Servlet {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private long hits;
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    /**
     * 获取缓存命中率
     *
     * @return
     */
    public synchronized double getCacheHitRatio() {
        return cacheHits / hits;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors;
            }
        }
        encodeIntoResponse(res, lastFactors);
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
