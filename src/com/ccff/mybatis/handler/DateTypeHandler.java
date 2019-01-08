package com.ccff.mybatis.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DateTypeHandler implements TypeHandler<Date> {
    //转换日期类型的辅助类
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        //指定传入的Java参数对应JDBC中的数据库类型
        System.out.println("其他逻辑");
        preparedStatement.setDate(i,date);
        System.out.println("其他逻辑");
    }

    @Override
    public Date getResult(ResultSet resultSet, String columnName) throws SQLException {
        System.out.println("其他逻辑");
        return resultSet.getDate(columnName);
    }

    @Override
    public Date getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        System.out.println("其他逻辑");
        return resultSet.getDate(columnIndex);
    }

    @Override
    public Date getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        System.out.println("其他逻辑");
        return callableStatement.getDate(columnIndex);
    }
}
