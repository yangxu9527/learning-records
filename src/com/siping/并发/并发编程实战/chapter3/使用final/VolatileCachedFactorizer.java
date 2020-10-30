package com.siping.并发.并发编程实战.chapter3.使用final;

import com.siping.并发.并发编程实战.provider.Servlet;
import com.siping.并发.并发编程实战.provider.ServletRequest;
import com.siping.并发.并发编程实战.provider.ServletResponse;

import java.math.BigInteger;

/**
 * @author Xu.Yang
 * @date 2019/3/27 17 12
 * @desc: 与cache相关的操作不会相互干扰，因为OneValueCache是不可变的，并且在每条相应的代码路径中只会访问它一次。再通过volatile来确保可见性。
 * 虽然没有使用锁，但仍然是线程安全的
 */
public class VolatileCachedFactorizer implements Servlet {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void service(ServletRequest req, ServletResponse res) {

        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = cache.getLastFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        encodeIntoResponse(res, factors);

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
