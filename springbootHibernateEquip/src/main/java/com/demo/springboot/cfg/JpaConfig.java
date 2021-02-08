package com.demo.springboot.cfg;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class JpaConfig {
	
//	@Bean(name = "testDB")
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dataSourceBuilder.url("jdbc:sqlserver://localhost:53802;databaseName=javatest");
//        dataSourceBuilder.username("sa");
//        dataSourceBuilder.password("sa123");
//        
//        return dataSourceBuilder.build();
//    }
	
	@Bean(name = "newDB")
    public DataSource getDataSource(String conn) {
//		String str = String.format("Hi,%s", "王力");
		String strURL = String.format("jdbc:sqlserver://localhost:53802;databaseName=javatest");
		
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dataSourceBuilder.url("jdbc:sqlserver://localhost:53802;databaseName=javatest");
        dataSourceBuilder.url(strURL);        
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sa123");
        
        return dataSourceBuilder.build();
    }
}
