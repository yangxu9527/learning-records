package com.siping.数据库.sqlutil.jsqlparser;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:58
 * @description:
 */
public class VisitContext {

    private Object firstParam;
    private Object param;

    public void setFirstParam(Object firstParam) {
        this.firstParam = firstParam;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Object getFirstParam() {
        return firstParam;
    }

    public Object getParam(int i) {
        return param;
    }

    public void removeFirstParam() {
    }
}
