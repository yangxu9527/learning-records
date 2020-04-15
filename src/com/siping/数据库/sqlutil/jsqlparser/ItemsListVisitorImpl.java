package com.siping.数据库.sqlutil.jsqlparser;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsListVisitor;
import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.expression.operators.relational.NamedExpressionList;
import net.sf.jsqlparser.statement.select.SubSelect;
import org.apache.lucene.util.CollectionUtil;

import java.util.List;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:55
 * @description:
 */
public class ItemsListVisitorImpl implements ItemsListVisitor {

    @Override
    public void visit(SubSelect subSelect) {
        subSelect.getSelectBody().accept(new SelectVisitorImpl());
    }

    @Override
    public void visit(ExpressionList expressionList) {
        List<Expression> list = expressionList.getExpressions();
        if (list != null && list.size() != 0) {
            for (Expression expr : list) {
                expr.accept(new ExpressionVisitorImpl());
            }
        }
    }

    @Override
    public void visit(NamedExpressionList namedExpressionList) {

    }

    @Override
    public void visit(MultiExpressionList multiExpressionList) {

    }
}
