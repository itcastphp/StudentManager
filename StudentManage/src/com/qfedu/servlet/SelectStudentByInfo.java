package com.qfedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Student;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.Init;


public class SelectStudentByInfo extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FindStudentImp findStudentImp = new FindStudentImp();
		Init.init(findStudentImp);
		String info = req.getParameter("info");
		List<Student> students = findStudentImp.getStudentsByInfo(info);
		req.setAttribute("students",students);
		req.getRequestDispatcher("/selectStudentByInfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
