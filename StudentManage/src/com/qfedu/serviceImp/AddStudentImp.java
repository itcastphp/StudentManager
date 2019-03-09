package com.qfedu.serviceImp;

import com.qfedu.dao.StudentDao;
import com.qfedu.domain.Student;
import com.qfedu.service.AddStudent;

public class AddStudentImp implements AddStudent{
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int addStudent(Student student) {
		return studentDao.insertStudent(student);
	}

}
