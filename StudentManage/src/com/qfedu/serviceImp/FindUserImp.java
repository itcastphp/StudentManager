package com.qfedu.serviceImp;

import com.qfedu.daoImp.UserDaoImpl;
import com.qfedu.service.FindUser;

public class FindUserImp implements FindUser{
	private UserDaoImpl userDaoImpl;
	
	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	//�û���¼
	@Override
	public Boolean findUser(String nickname, String password) {
		return userDaoImpl.selectUser(nickname, password);
	}
	
	//�����û�ͷ��
	@Override
	public String findUserPhoto(String nickname, String password) {	
		return userDaoImpl.selectUserPhoto(nickname, password);
	}

}
