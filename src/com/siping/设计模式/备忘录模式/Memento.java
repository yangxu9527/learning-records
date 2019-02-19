package com.siping.设计模式.备忘录模式;

/**
 * @author Xu.Yang
 * @date 2019/2/19 16 46
 * @desc: 包含了要被恢复的对象的状态
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
