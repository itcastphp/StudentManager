package com.qfedu.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.daoImp.StudentDaoImpl;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.serviceImp.RemoveStudentImp;
import com.qfedu.util.Init;
import com.qfedu.util.MySqlUtil;

@WebServlet("/deleteStudentBySid")
public class DeleteStudentBySid extends HttpServlet{
	public void init(RemoveStudentImp removeStudentImp ) {
		Connection connection = MySqlUtil.getConnection();
		StudentDaoImpl studentDaoImpl = new  StudentDaoImpl();
		studentDaoImpl.setConnection(connection);
		removeStudentImp.setStudentDao(studentDaoImpl);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RemoveStudentImp removeStudentImp = new RemoveStudentImp();
		init(removeStudentImp);
		String queryString = req.getQueryString();
		String sid=queryString.split("=")[1];
		removeStudentImp.removeStudentBySid(sid);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
