package com.qfedu.serviceImp;

import java.util.List;
import com.qfedu.dao.StudentDao;
import com.qfedu.domain.Page;
import com.qfedu.domain.Student;
import com.qfedu.service.FindStudent;

public class FindStudentImp implements FindStudent{
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//�����Ա��ѯѧ��
	@Override
	public List<Student> getStudentBySsex(String sex) {
		return studentDao.selectStudentBySex(sex);
	}

	//�����������Ա����ģ����ѯ
	@Override
	public List<Student> getStudentsByInfo(String info) {
		return studentDao.selectStudentByInfo(info);
	}

	//��ѯ���е�ѧ��
	@Override
	public List<Student> getStudentAll() {
		return studentDao.selectStudentAll();
	}

	//��ҳ��ѯ
	@Override
	public Page buildData(int startPage) {
		Page page = new Page();
		page.setStudents(studentDao.selectStudentByLimit(startPage));
		page.setTotalCount(studentDao.selectCountStudent());
		page.setThisPage(startPage);
		return page;
	}
}
