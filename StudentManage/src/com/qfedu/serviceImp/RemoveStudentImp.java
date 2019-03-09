package com.qfedu.serviceImp;

import com.qfedu.dao.StudentDao;
import com.qfedu.service.RemoveStudent;

public class RemoveStudentImp implements RemoveStudent{
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//����ѧ��ɾ��ѧ��
	@Override
	public void removeStudentBySid(String sid) {
		studentDao.deleteStudentBySid(sid);
	}

}
