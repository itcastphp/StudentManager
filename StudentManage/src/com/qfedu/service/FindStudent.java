package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Page;
import com.qfedu.domain.Student;

public interface FindStudent {
	//根据性别查询学生
	public List<Student> getStudentBySsex(String sex);
	
	//根据姓名和性别进行模糊查询
	public List<Student> getStudentsByInfo(String info);
	
	//查询所有学生信息
	public List<Student> getStudentAll();
	
	//分页查询学生的信息
	public Page buildData(int startPage);
}
