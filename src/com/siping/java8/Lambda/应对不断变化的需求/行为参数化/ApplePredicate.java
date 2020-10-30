package com.siping.java8.Lambda.应对不断变化的需求.行为参数化;

import com.siping.java8.Lambda.应对不断变化的需求.Apple;

/**
 * 对Demo1的优化
 *
 * @author siping-yx
 * @version 1.0
 * @date 2017年12月27日
 */
public interface ApplePredicate {

    boolean test(Apple apple);
}
