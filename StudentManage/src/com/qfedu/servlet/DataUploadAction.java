package com.qfedu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.qfedu.daoImp.DataDaoImpl;
import com.qfedu.serviceImp.AddDataImp;
import com.qfedu.util.DruidUtil;
import com.qfedu.util.UuidUtil;

@WebServlet("/dataUploadAction")
public class DataUploadAction extends HttpServlet{
	private AddDataImp addDataImp=null;
	private List<String> datas=new ArrayList<String>();
	public void intiData() {
		Connection connection = DruidUtil.getConnection();
		DataDaoImpl dataDaoImpl = new DataDaoImpl();
		dataDaoImpl.setConnection(connection);
		addDataImp=new AddDataImp();
		addDataImp.setDataDao(dataDaoImpl);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		intiData();
		String filePath = getServletContext().getRealPath("file");
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		String username="";
		String data="";
		if(ServletFileUpload.isMultipartContent(req)) {
			try {
				List<FileItem> parseRequest = servletFileUpload.parseRequest(req);
				Iterator<FileItem> iterator = parseRequest.iterator();
				while(iterator.hasNext()) {
					FileItem fileItem = iterator.next();
					if(fileItem.isFormField()) {
						String fieldValue = fileItem.getString("utf-8");
						if(username=="") {
							username=fieldValue;
						}
					}else {
						String name = fileItem.getName();
						name=new String(name.getBytes("gbk"), "utf-8");
						req.setCharacterEncoding("utf-8");
						String uuid = UuidUtil.getUuid();
						String mainname=name.substring(name.lastIndexOf("/")+1, name.indexOf("."));
						String exename=name.substring(name.indexOf("."));
						filePath=filePath+"\\"+mainname+uuid+exename;
						data=getServletContext().getContextPath()+"/file"+"/"+mainname+uuid+exename;
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
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		int row = addDataImp.UploadData(username, data);
		req.getSession().setAttribute("username", username);
		datas.add(data);
		req.getSession().setAttribute("files", datas);
		if(row==1) {
			resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
		}	
	}
}











