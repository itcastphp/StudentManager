package com.qfedu.service;

public interface FindUser {
	//�û���¼
	public Boolean findUser(String nickname, String password);
	//�����û�ͷ��
	public String findUserPhoto(String nickname,String password);
}
