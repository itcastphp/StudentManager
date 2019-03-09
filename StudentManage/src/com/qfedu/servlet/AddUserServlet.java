package com.qfedu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.qfedu.daoImp.UserDaoImpl;
import com.qfedu.serviceImp.AddUserImp;
import com.qfedu.util.MySqlUtil;
import com.qfedu.util.UuidUtil;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet{
	private AddUserImp addUserImp=null;
	public void initData() {
		Connection connection = MySqlUtil.getConnection();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.setConnection(connection);
		addUserImp = new AddUserImp();
		addUserImp.setUserDao(userDaoImpl);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		initData();
		String filePath = getServletContext().getRealPath("/photo");
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		String nickname ="";
		String password ="";
		String email="";
		String photo="";
		String photoServletPath = "";
		if(ServletFileUpload.isMultipartContent(req)) {	
			try {
				List<FileItem> fileItems = servletFileUpload.parseRequest(req);
				Iterator<FileItem> iterator = fileItems.iterator();
				while(iterator.hasNext()) {
					FileItem fileItem = iterator.next();
					if(fileItem.isFormField()) {
						String fieldValue = fileItem.getString("utf-8");
						if(nickname=="") {
							nickname=fieldValue;
						}else if(password=="") {
							password=fieldValue;
						}else {
							email=fieldValue;
						}
					}else {
						String name = fileItem.getName();
						name=new String(name.getBytes("gbk"), "utf-8");
						req.setCharacterEncoding("utf-8");
						resp.setContentType("text/html; charset=utf-8");
						System.out.println(name);
						String uuid = UuidUtil.getUuid();
						String mainname=name.substring(name.lastIndexOf("/")+1,name.indexOf("."));
						String extname=name.substring(name.indexOf("."));
						photoServletPath="/"+mainname+uuid+extname;
						photo=getServletContext().getContextPath()+"/photo"+photoServletPath;
						filePath=filePath+"\\"+mainname+uuid+extname;
						InputStream inputStream = fileItem.getInputStream();
						File finalFile =new File(filePath);
						FileOutputStream fos = new FileOutputStream(finalFile);
						int count=0;
						byte[] bytes=new byte[1024];
						while((count=inputStream.read(bytes))!=-1) {
							fos.write(bytes, 0, count);
						}
						fos.flush();
					
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(nickname+"--"+password+"--"+email);
		int row = addUserImp.registerUser(nickname, password, email, photo);
		req.getSession().setAttribute("username", nickname);
		req.getSession().setAttribute("info", photo);
		if(row==1) {
			resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
		}	
	}
}
