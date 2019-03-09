package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Student;

public interface StudentDao {
	//根据性别查询学生
	public List<Student> selectStudentBySex(String sex);
	
	//根据姓名和性别进行模糊查询
	public List<Student> selectStudentByInfo(String info);
	
	//查询所有学生信息
	public List<Student> selectStudentAll();
	
	//根据主键删除学生
	public void deleteStudentBySid(String sid);
	
	//添加学生
	public int insertStudent(Student student);
	
	//统计学生人数
	public int selectCountStudent();
	
	//当前分页结果集
	public List<Student> selectStudentByLimit(int startPage);
}
