package com.qfedu.test;

import java.sql.Connection;
import com.qfedu.util.DruidUtil;

public class test {

	public static void main(String[] args) {
		Connection connection =DruidUtil.getConnection();
		System.out.println(connection);
	}

}
