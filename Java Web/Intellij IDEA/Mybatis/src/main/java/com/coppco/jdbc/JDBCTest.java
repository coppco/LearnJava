package com.coppco.jdbc;

import com.coppco.HJLog.HJLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {

    /***
     * 传统 JDBC 操作
     * 1、频繁创建、释放数据库资源
     * 2、SQL语句在代码中, 不利于后期维护
     * 3、PreparedStatement中参数存在硬编码
     * 4、结果集也存在硬编码
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/r1225?characterEncoding=utf-8&amp;useSSL=false", "root", "123456");
            String sql = "select * from user where username =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "王五");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                HJLog.logger.info(resultSet.getString("id") + "=======" + resultSet.getString("username"));
            }
        } catch (Exception e) {
            HJLog.logger.error(e);
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    HJLog.logger.error(e);
                }
            }

            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                    ;
                } catch (Exception e) {
                    HJLog.logger.error(e);
                }
            }

            if (null != connection) {
                try {
                    connection.close();
                    ;
                } catch (Exception e) {
                    HJLog.logger.error(e);
                }
            }
        }
    }


}
