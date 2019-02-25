package com.siping.设计模式.状态模式;

/**
 * @author Xu.Yang
 * @date 2019/2/25 14 27
 * @desc:
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}
