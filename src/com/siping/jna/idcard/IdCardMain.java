package com.siping.jna.idcard;

import com.sun.jna.Pointer;

import java.math.BigDecimal;

/**
 * @author Yang Xu
 * @date 2020/8/26 18:44
 * @description:
 */
public class IdCardMain {

    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("2");
        Test test = new Test();
        test.setTest(decimal);
        decimal = decimal.add(new BigDecimal("1"));
        System.out.println(test.getTest());

    }
}

class Test{
    private BigDecimal test;

    public BigDecimal getTest() {
        return test;
    }

    public void setTest(BigDecimal test) {
        this.test = test;
    }
}
