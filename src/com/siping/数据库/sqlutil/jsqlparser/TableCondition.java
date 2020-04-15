package com.siping.数据库.sqlutil.jsqlparser;

/**
 * @author Yang Xu
 * @date 2020/4/15 10:44
 * @description:
 */
public class TableCondition {

    private String operator;

    private String fieldName;

    private String fieldValue;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
