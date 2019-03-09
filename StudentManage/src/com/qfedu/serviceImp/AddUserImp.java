package com.qfedu.serviceImp;


import java.io.FileInputStream;
import java.sql.Date;
import java.util.Properties;
import com.qfedu.dao.UserDao;
import com.qfedu.domain.User;
import com.qfedu.service.AddUser;
import com.qfedu.util.EmailUtil;
import com.qfedu.util.UuidUtil;


public class AddUserImp implements AddUser{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int registerUser(String nickname, String password, String email, String photo) {
		User user = new User();
		user.setNickname(nickname);
		user.setPassword(password);
		user.setEmail(email);
		user.setRegisterTime(new Date(new java.util.Date().getTime()));
		String linsence = UuidUtil.getUuid();
		user.setLinsence(linsence);
		user.setPhoto(photo);
		//构建Properties对象
		Properties properties = System.getProperties();
		try {
			properties.load(new FileInputStream("C:/Users/Administrator/Desktop/javaEE/StudentManage/src/com/qfedu/util/email.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//发送激活邮件
		EmailUtil emailUtil = new EmailUtil(properties.getProperty("mail.smtp"), properties.getProperty("mail.port"), properties.getProperty("mail.username"), properties.getProperty("mail.password"));
		
		//构建主题
		String theme="这是一封来自javaEE的激活的邮件";
		
		//构建邮件的内容
		String content = "<html><head></head><body><h2>这里你看到的是一封激活邮件,请点击超链接激活....</h2>"
				+"<a href='http://192.168.43.226:8080/StudentManage/activeUserAction?linsence="+linsence+"'>http://192.168.43.226:8080/StudentManage/activeUserAction?linsence="
						+ linsence + "</a></body></html>";
		
		emailUtil.sendEmail(properties.getProperty("mail.username"), email, theme, content);
		return userDao.insertUser(user);

	}

	@Override
	public void activeUser(String linsenceCode) {
		
	}
}
