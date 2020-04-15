package com.siping.数据库.sqlutil.jsqlparser;

import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.Expression;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:56
 * @description:
 */
public class AbstractVisitor {
    protected VisitContext context;
    private boolean valid;

    public boolean isNotValid() {
        return !valid;
    }

    public VisitContext getContext() {
        return context;
    }

    public void setContext(VisitContext context) {
        this.context = context;
    }

    public boolean isValid() {
        return valid;
    }

    public AbstractVisitor(VisitContext ctx) {
        this.context = ctx;
    }

    protected void setValid(boolean b) {
        this.valid = b;
    }

    protected Expression createTrueEquals() {
        return null;
    }

    // 二元表达式
    public void visitBinaryExpression(BinaryExpression binaryExpression) {
        binaryExpression.getLeftExpression()
                .accept(new ExpressionVisitorImpl(this.context));
        binaryExpression.getRightExpression().accept(
                new ExpressionVisitorImpl(this.context));
    }
}
