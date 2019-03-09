package com.qfedu.service;

public interface AddUser {
	//注册用户
	public int registerUser(String nickname,String password,String email,String photo); 
	
	//激活用户
	public void  activeUser(String linsenceCode);
}
