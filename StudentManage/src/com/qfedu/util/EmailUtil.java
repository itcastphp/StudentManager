package com.qfedu.util;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtil {
	//构建加载properties文件的对象
	private  Properties properties;
	
	//构建SMTP的会话对象
	private Session session;
	 
	//构建邮件原文和源信息对象
	private MimeMessage message;
	
	//构造方法和auth认证
	public EmailUtil(String smtpHost,String port, String username,String  password) {
		//完成认证
		AuthUtil authUtil = new AuthUtil(username, password);
		//设置会话信息
		properties = System.getProperties();
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		//绑定auth和properties组建Session对象
		session=Session.getDefaultInstance(properties, authUtil);	
	}
	
	//发送邮件
	public Boolean sendEmail(String src,String target,String theme,String content) {
		//构建源信息对象
		message = new MimeMessage(session);
		try {
			//设置邮件发送者
			message.setFrom(new InternetAddress(src));
			
			//设置邮件接收者
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(target));
			
			//设置邮件的主题
			message.setSubject(theme,"utf-8");
			
			//设置邮件的内容
			message.setContent(content, "text/html;charset=utf-8");
			System.out.println(src+target+theme+content);
			//发送邮件
			Transport.send(message);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
}
