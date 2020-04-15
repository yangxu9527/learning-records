package com.siping.数据库.sqlutil.jsqlparser;

import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItemVisitor;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:36
 * @description:
 */
public class SelectItemVisitorImpl implements SelectItemVisitor {


    @Override
    public void visit(AllColumns allColumns) {

    }

    @Override
    public void visit(AllTableColumns allTableColumns) {

    }

    @Override
    public void visit(SelectExpressionItem selectExpressionItem) {
        selectExpressionItem.getExpression().accept(new ExpressionVisitorImpl());
    }
}
