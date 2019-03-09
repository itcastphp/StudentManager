package com.qfedu.util;

import java.sql.Connection;

import com.qfedu.daoImp.StudentDaoImpl;
import com.qfedu.serviceImp.FindStudentImp;

public class Init {
	public static void init(FindStudentImp findStudentImp) {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Connection connection = MySqlUtil.getConnection();
		studentDaoImpl.setConnection(connection);
		findStudentImp.setStudentDao(studentDaoImpl);
	}
}
