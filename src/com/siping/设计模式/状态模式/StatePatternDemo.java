package com.siping.设计模式.状态模式;

import org.junit.Test;

/**
 * @author Xu.Yang
 * @date 2019/2/25 15 01
 * @desc:
 */
public class StatePatternDemo {

    @Test
    public void test() {
        Context context = new Context();
        State startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        State stopState = new StartState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());

    }
}
