package com.qfedu.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {
	private static Connection connection=null;
	public static Connection getConnection() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("C:/Users/Administrator/Desktop/javaEE/StudentManage/src/com/qfedu/util/druid.properties"));
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
		
	}
}
