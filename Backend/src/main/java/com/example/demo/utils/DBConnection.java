/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author AZ
 */
public class DBConnection implements Serializable {
    public static Connection createConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://database-1.ctuzmxjr97gn.ap-southeast-1.rds.amazonaws.com:1433;databaseName=FireAlarmDB";
        conn = DriverManager.getConnection(url, "admin", "123456789");
        return conn;
    }
}
