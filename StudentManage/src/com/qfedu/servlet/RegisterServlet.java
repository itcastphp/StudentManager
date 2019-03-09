package com.qfedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.serviceImp.CheckNumber;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		System.out.println(phone);
		resp.setContentType("text/html; charset=utf-8");
		CheckNumber checkNumber = new CheckNumber();
		boolean result = checkNumber.checkNumber(phone);
		if(result) {
			resp.getWriter().print(result);
		}
	}
}
