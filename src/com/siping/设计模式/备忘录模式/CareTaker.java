package com.siping.设计模式.备忘录模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xu.Yang
 * @date 2019/2/19 16 48
 * @desc: Caretaker 对象负责从 Memento 中恢复对象的状态
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
