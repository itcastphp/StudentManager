package com.qfedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.Init;

@WebServlet("/selectStudentAllAjax")
public class SelectStudentAllAjax extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FindStudentImp findStudentImp = new FindStudentImp();
		Init.init(findStudentImp);
		List<Student> students = findStudentImp.getStudentAll();
		Gson gson = new Gson();
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().print(gson.toJson(students));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
