package com.qfedu.service;

public interface FindUser {
	//用户登录
	public Boolean findUser(String nickname, String password);
	//查找用户头像
	public String findUserPhoto(String nickname,String password);
}
