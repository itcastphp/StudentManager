package com.qfedu.dao;

import com.qfedu.domain.User;

public interface UserDao {
	//ע���û�
	public int insertUser(User user); 
	
	//�����û�
	public void updateUser(String linsenceCode);
	
	//�û���¼
	public Boolean selectUser(String nickname,String password);
	
	//�����û�ͷ��
	public String selectUserPhoto(String nickname,String password);
}
