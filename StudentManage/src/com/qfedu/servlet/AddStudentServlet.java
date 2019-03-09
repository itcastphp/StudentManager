package com.qfedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qfedu.daoImp.StudentDaoImpl;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.AddStudentImp;
import com.qfedu.util.MySqlUtil;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet{
	public void init(AddStudentImp addStudentImp ) {
		Connection connection = MySqlUtil.getConnection();
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		studentDaoImpl.setConnection(connection);
		addStudentImp.setStudentDao(studentDaoImpl);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studentStr = req.getParameter("student");
		System.out.println(studentStr);
		Gson gson = new Gson();
		Student student = gson.fromJson(studentStr, Student.class);
		AddStudentImp addStudentImp = new AddStudentImp();
		init(addStudentImp);
		int row = addStudentImp.addStudent(student);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
