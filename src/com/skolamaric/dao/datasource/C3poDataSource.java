package com.skolamaric.dao.datasource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.skolamaric.utils.KONSTANTE;

public class C3poDataSource {
	 private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	 
	    static {
	        try {
	            cpds.setDriverClass(KONSTANTE.myDriver);
	            cpds.setJdbcUrl(KONSTANTE.myUrl);
	            cpds.setUser("root");
	            cpds.setPassword("root");
	            cpds.setInitialPoolSize(10);
	        } catch (PropertyVetoException e) {
	            // handle the exception
	        }
	    }
	      
	    public static Connection getConnection() throws SQLException {
	        return cpds.getConnection();
	    }
	     
	    private C3poDataSource(){}
	}

