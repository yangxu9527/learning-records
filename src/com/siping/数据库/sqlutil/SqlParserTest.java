package com.siping.数据库.sqlutil;

import com.siping.数据库.sqlutil.jsqlparser.SelectVisitorImpl;
import com.siping.数据库.sqlutil.jsqlparser.VisitContext;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.Select;
import org.junit.Test;

import java.io.StringReader;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:26
 * @description:
 */
public class SqlParserTest {

    @Test
    public void test() throws JSQLParserException {
        String sql = "SELECT * FROM erp_pp_version v LEFT JOIN erp_pp_routing r ON v.routing_id=r.id";
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        //如果是select就将sql转成SELECT对象
        Select select = (Select) parserManager.parse(new StringReader(sql));
        VisitContext visitContext = new VisitContext();
        //访问各个visitor
        select.getSelectBody().accept(new SelectVisitorImpl(visitContext));
        System.out.println(select.toString());
    }

    public String parseSql(String sql, VisitContext params) {
        /*CCJSqlParserManager parserManager = new CCJSqlParserManager();
        try {
            //解析SQL语句
            Select select = (Select) parserManager.parse(new StringReader(sql));
            SelectBody body = select.getSelectBody();
            VisitContext vc = new VisitContext( params);
            //vc.setTableFilterFactory(tableFilterFactory);//表的字段过滤
            //访问SQL并根据SQL中涉及的表来增强SQL
            body.accept(new SelectVisitorImpl(vc));
            ExpressionDeParser expressionDeParser = new ExpressionDeParser();
            StringBuilder stringBuffer = new StringBuilder();
            //针对ORACLE的SQL生成
            SelectDeParser deParser = new OracleSelectDeParser(expressionDeParser, stringBuffer);
            expressionDeParser.setSelectVisitor(deParser);
            expressionDeParser.setBuffer(stringBuffer);

            body.accept(deParser);
            return new FilterResult(deParser.getBuffer().toString(), vc.getResultSqlParams());
        } catch (JSQLParserException e) {
            throw new FilterException(e);
        }*/
        return "";
    }
}
