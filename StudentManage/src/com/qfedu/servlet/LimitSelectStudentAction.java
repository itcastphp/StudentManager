package com.qfedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qfedu.daoImp.StudentDaoImpl;
import com.qfedu.domain.Page;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.DruidUtil;
@WebServlet("/limitSelectStudentAction")
public class LimitSelectStudentAction extends HttpServlet{
	private FindStudentImp findStudentImp=null;
	public void initData() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		Connection connection = DruidUtil.getConnection();
		studentDaoImpl.setConnection(connection);
		findStudentImp=new FindStudentImp();
		findStudentImp.setStudentDao(studentDaoImpl);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		initData();
		int startPage = Integer.parseInt(req.getParameter("startPage"));
		Page page = findStudentImp.buildData(startPage);
		if(page!=null) {
			Gson gson = new Gson();
			String pageStr = gson.toJson(page);
			resp.setContentType("text/html; charset=utf-8");
			resp.getWriter().print(pageStr);
		}
		
		/*req.getSession().setAttribute("page", page);
		resp.sendRedirect(getServletContext().getContextPath()+"/main.jsp");*/
	}
	
}
