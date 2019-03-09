package com.qfedu.dao;

import com.qfedu.domain.User;

public interface UserDao {
	//注册用户
	public int insertUser(User user); 
	
	//激活用户
	public void updateUser(String linsenceCode);
	
	//用户登录
	public Boolean selectUser(String nickname,String password);
	
	//查找用户头像
	public String selectUserPhoto(String nickname,String password);
}
