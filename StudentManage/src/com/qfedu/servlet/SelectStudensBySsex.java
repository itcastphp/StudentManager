package com.qfedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qfedu.daoImp.StudentDaoImpl;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.Init;
import com.qfedu.util.MySqlUtil;

@WebServlet("/selectStudensBySsex")
public class SelectStudensBySsex extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FindStudentImp findStudentImp = new FindStudentImp();
		Init.init(findStudentImp);
		String sex = req.getParameter("sex");
		List<Student> students = findStudentImp.getStudentBySsex(sex);
		req.setAttribute("students",students);
		req.getRequestDispatcher("/selectStudentBySsex.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
