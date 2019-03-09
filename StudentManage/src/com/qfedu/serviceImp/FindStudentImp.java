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
	//根据性别查询学生
	@Override
	public List<Student> getStudentBySsex(String sex) {
		return studentDao.selectStudentBySex(sex);
	}

	//根据姓名和性别进行模糊查询
	@Override
	public List<Student> getStudentsByInfo(String info) {
		return studentDao.selectStudentByInfo(info);
	}

	//查询所有的学生
	@Override
	public List<Student> getStudentAll() {
		return studentDao.selectStudentAll();
	}

	//分页查询
	@Override
	public Page buildData(int startPage) {
		Page page = new Page();
		page.setStudents(studentDao.selectStudentByLimit(startPage));
		page.setTotalCount(studentDao.selectCountStudent());
		page.setThisPage(startPage);
		return page;
	}
}
