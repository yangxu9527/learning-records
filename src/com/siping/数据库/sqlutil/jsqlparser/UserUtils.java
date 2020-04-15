package com.siping.数据库.sqlutil.jsqlparser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:52
 * @description:
 */
public class UserUtils {
    public static List<TableCondition> getTableCondition(String tableName) {
        List<TableCondition> list = new ArrayList<>(2);
        if ("erp_pp_routing".equals(tableName.toLowerCase())) {
            TableCondition condition =new TableCondition();
            condition.setFieldName("create_by");
            condition.setOperator("=");
            condition.setFieldValue("1");
            list.add(condition);
        }
        if ("erp_pp_version".equals(tableName.toLowerCase())) {
            TableCondition condition =new TableCondition();
            condition.setFieldName("org_id");
            condition.setOperator("=");
            condition.setFieldValue("2");
            list.add(condition);
        }
        return list;
    }
}
