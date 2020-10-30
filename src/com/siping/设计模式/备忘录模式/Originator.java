package com.siping.设计模式.备忘录模式;

/**
 * @author Xu.Yang
 * @date 2019/2/19 16 47
 * @desc: 创建并在 Memento 对象中存储状态
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento) {
        state = Memento.getState();
    }
}
