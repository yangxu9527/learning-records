package com.siping.数据库.sqlutil.jsqlparser;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.values.ValuesStatement;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:32
 * @description:
 */
public class SelectVisitorImpl extends AbstractVisitor implements SelectVisitor {

    public SelectVisitorImpl(VisitContext ctx) {
        super(ctx);
    }

    // 主要工作就是实现各种底层visitor，然后在解析的时候添加条件
    // 正常的select，也就是包含全部属性的select
    @Override
    public void visit(PlainSelect plainSelect) {
        // 访问 select
        if (plainSelect.getSelectItems() != null) {
            for (SelectItem item : plainSelect.getSelectItems()) {
                item.accept(new SelectItemVisitorImpl(this.context));
            }
        }

        // 访问from
        FromItem fromItem = plainSelect.getFromItem();
        FromItemVisitorImpl fromItemVisitorImpl = new FromItemVisitorImpl(this.context);
        fromItem.accept(fromItemVisitorImpl);

        // 访问where
        if (plainSelect.getWhere() != null) {
            plainSelect.getWhere().accept(new ExpressionVisitorImpl(this.context));
        }

        //过滤增强的条件
        if (fromItemVisitorImpl.getEnhancedCondition() != null) {
            if (plainSelect.getWhere() != null) {
                Expression expr = new Parenthesis(plainSelect.getWhere());
                Expression enhancedCondition = new Parenthesis(fromItemVisitorImpl.getEnhancedCondition());
                AndExpression and = new AndExpression(enhancedCondition, expr);
                plainSelect.setWhere(and);
            } else {
                plainSelect.setWhere(fromItemVisitorImpl.getEnhancedCondition());
            }
        }

        // 访问join
        if (plainSelect.getJoins() != null) {
            for (Join join : plainSelect.getJoins()) {
                join.getRightItem().accept(new FromItemVisitorImpl(this.context));
            }
        }

        // 访问 order by
        if (plainSelect.getOrderByElements() != null) {
            for (OrderByElement orderByElement : plainSelect
                    .getOrderByElements()) {
                orderByElement.getExpression().accept(
                        new ExpressionVisitorImpl(this.context));
            }
        }

        // 访问group by having
        if (plainSelect.getHaving() != null) {
            plainSelect.getHaving().accept(new ExpressionVisitorImpl(this.context));
        }
    }

    @Override
    public void visit(SetOperationList setOperationList) {
        for (SelectBody plainSelect : setOperationList.getSelects()) {
            plainSelect.accept(new SelectVisitorImpl(this.context));
        }

    }

    @Override
    public void visit(WithItem withItem) {
        withItem.getSelectBody().accept(new SelectVisitorImpl(this.context));
    }

    @Override
    public void visit(ValuesStatement valuesStatement) {

    }
}
