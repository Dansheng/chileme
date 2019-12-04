package com.clm.Dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUnit {
	private static Connection conn=null;
	static{
		// Create properties
		Properties properties = new Properties();
		FileReader fr = null;
		try {
        	fr = new FileReader("conf.properties");
        	properties.load(fr);
        	fr.close();
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		// Connect mysql
        try {
            Class.forName(properties.getProperty("driver"));
            String url=properties.getProperty("jdbcUrl");
            String username=properties.getProperty("user");
            String password=properties.getProperty("password");
            conn=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
        	throw new RuntimeException(e+" failed to connect mysql");
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void CloseConnection()
    {
    	if(getConnection()!=null)
    	{
    		try
        	{
        		getConnection().close();
        	}catch(SQLException e)
        	{
        		e.printStackTrace();
        	}
    	}
    }

}
