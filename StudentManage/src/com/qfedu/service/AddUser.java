package com.qfedu.service;

public interface AddUser {
	//ע���û�
	public int registerUser(String nickname,String password,String email,String photo); 
	
	//�����û�
	public void  activeUser(String linsenceCode);
}
