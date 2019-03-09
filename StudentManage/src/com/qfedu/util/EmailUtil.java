package com.qfedu.util;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtil {
	//��������properties�ļ��Ķ���
	private  Properties properties;
	
	//����SMTP�ĻỰ����
	private Session session;
	 
	//�����ʼ�ԭ�ĺ�Դ��Ϣ����
	private MimeMessage message;
	
	//���췽����auth��֤
	public EmailUtil(String smtpHost,String port, String username,String  password) {
		//�����֤
		AuthUtil authUtil = new AuthUtil(username, password);
		//���ûỰ��Ϣ
		properties = System.getProperties();
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		//��auth��properties�齨Session����
		session=Session.getDefaultInstance(properties, authUtil);	
	}
	
	//�����ʼ�
	public Boolean sendEmail(String src,String target,String theme,String content) {
		//����Դ��Ϣ����
		message = new MimeMessage(session);
		try {
			//�����ʼ�������
			message.setFrom(new InternetAddress(src));
			
			//�����ʼ�������
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(target));
			
			//�����ʼ�������
			message.setSubject(theme,"utf-8");
			
			//�����ʼ�������
			message.setContent(content, "text/html;charset=utf-8");
			System.out.println(src+target+theme+content);
			//�����ʼ�
			Transport.send(message);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
}
