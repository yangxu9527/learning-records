package com.siping.数据库.sqlutil.jsqlparser;

import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;

import java.util.Iterator;

/**
 * @author Yang Xu
 * @date 2020/4/15 13:56
 * @description:
 */
public class OracleSelectDeParser extends SelectDeParser {

    public OracleSelectDeParser(ExpressionDeParser expressionDeParser, StringBuilder sb) {
        super(expressionDeParser,  sb);
    }

    /**
     * 重写父类方法，去掉父类方法中table前的as
     */
    @Override
    public void visit(Table tableName) {
        buffer.append(tableName.getName());
        Alias alias = tableName.getAlias();
        if (alias != null) {
            buffer.append(" ");
            buffer.append(alias);
        }
    }

    /**
     * 重写父类方法，在JOIN之前增加空格
     */
    @SuppressWarnings("unchecked")
    @Override
    public void deparseJoin(Join join) {
        if (join.isSimple()) {
            buffer.append(", ");
        } else {
            buffer.append(" ");
            if (join.isRight()) {
                buffer.append("RIGHT ");
            } else if (join.isNatural()) {
                buffer.append("NATURAL ");
            } else if (join.isFull()) {
                buffer.append("FULL ");
            } else if (join.isLeft()) {
                buffer.append("LEFT ");
            }
            if (join.isOuter()) {
                buffer.append("OUTER ");
            } else if (join.isInner()) {
                buffer.append("INNER ");
            }
            buffer.append("JOIN ");
        }

        FromItem fromItem = join.getRightItem();
        fromItem.accept(this);
        if (join.getOnExpression() != null) {
            buffer.append(" ON ");
            join.getOnExpression().accept(getExpressionVisitor());
        }
        if (join.getUsingColumns() != null) {
            buffer.append(" USING ( ");
            for (Iterator<Column> iterator = join.getUsingColumns().iterator(); iterator.hasNext();) {
                Column column = iterator.next();
                buffer.append(column.getColumnName());
                if (iterator.hasNext()) {
                    buffer.append(" ,");
                }
            }
            buffer.append(")");
        }
    }
}
