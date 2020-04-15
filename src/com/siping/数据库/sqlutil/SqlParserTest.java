package com.siping.数据库.sqlutil;

import com.siping.数据库.sqlutil.jsqlparser.SelectVisitorImpl;
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
        //访问各个visitor
        select.getSelectBody().accept(new SelectVisitorImpl());
        System.out.println(select.toString());
    }

}
