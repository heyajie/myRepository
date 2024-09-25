package com.pig.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class DBUtil {

    public static Connection getZHuMysqlConn() {
        Connection conn = null;
        final String url = "jdbc:mysql://192.168.2.3:3306/test?characterEncoding=utf8&useSSL=false&useOldAliasMetadataBehavior=true";
        System.out.println(url);
        final String user = "root";
        final String password = "123456";
        final String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) { e.printStackTrace();}
        //
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("...");
            System.out.println("##152...111...获取conn超时..err..从新获取...");
            try {
                TimeUnit.MINUTES.sleep(5);
                conn =  DriverManager.getConnection(url, user, password);
            } catch (Exception e2) {System.out.println("##158...222...获取conn超时..err");}
        }
        return conn;
    }
}
