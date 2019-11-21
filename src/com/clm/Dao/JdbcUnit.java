package com.clm.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUnit {
	private static Connection conn=null;
	static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://39.105.43.248:3306/clm?characterEncoding=utf-8";
            String username="root";
            String password="Slc1713011!";
            conn=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
        	throw new RuntimeException(e+" failed to connect mysql");
        }
    }
    public static Connection getConnection(){
        return conn;
    }
}
