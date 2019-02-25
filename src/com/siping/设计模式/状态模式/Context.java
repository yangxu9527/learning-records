package com.siping.设计模式.状态模式;

/**
 * @author Xu.Yang
 * @date 2019/2/25 14 26
 * @desc:
 */
public class Context {

    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
