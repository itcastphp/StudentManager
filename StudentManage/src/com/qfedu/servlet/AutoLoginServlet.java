package com.qfedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qfedu.daoImp.DataDaoImpl;
import com.qfedu.daoImp.UserDaoImpl;
import com.qfedu.serviceImp.FindDataImp;
import com.qfedu.serviceImp.FindUserImp;
import com.qfedu.util.MySqlUtil;

@WebServlet("/loginServlet")
public class AutoLoginServlet extends HttpServlet{
	private FindUserImp findUserImp=null;
	private Connection connection = MySqlUtil.getConnection();
	public void init() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.setConnection(connection);
		findUserImp = new FindUserImp();
		findUserImp.setUserDaoImpl(userDaoImpl);
	}
	private FindDataImp findDataImp=null;
	public void initData() {
		DataDaoImpl dataDaoImpl = new DataDaoImpl();
		dataDaoImpl.setConnection(connection);
		findDataImp=new FindDataImp();
		findDataImp.setDataDaoImpl(dataDaoImpl);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		init();
		initData();
		String nickname = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(nickname+"--"+password);
		String auto = req.getParameter("auto");
		String nameauto = req.getParameter("nameauto");
		Boolean b = findUserImp.findUser(nickname, password);
		if(b) {
			HttpSession session = req.getSession();
			session.setAttribute("username", nickname);
			if("yes".equals(auto)) {
				Cookie cookie = new Cookie("JSESSIONID", session.getId());
				cookie.setMaxAge(1800);
				resp.addCookie(cookie);
			}
			if("ok".equals(nameauto)) {
				Cookie cookie = new Cookie("uu", nickname);
				cookie.setMaxAge(1800);
				resp.addCookie(cookie);
			}
			String photo = findUserImp.findUserPhoto(nickname, password);
			req.getSession().setAttribute("info", photo);
			List<String> datas = findDataImp.findAllData();
			req.getSession().setAttribute("files", datas);
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/error.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
