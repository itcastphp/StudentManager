package com.qfedu.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySqlUtil {
	public static Connection getConnection() {
		//¼ÓÔØmysqlµÄÇý¶¯
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties properties = new Properties();
		Connection connection = null;
		File file = new File("C:/Users/Administrator/Desktop/javaEE/StudentManage/src/com/qfedu/util/db.properties");
		try {
			properties.load(new FileInputStream(file));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeAll(Connection connection, Statement statement) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (connection != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
