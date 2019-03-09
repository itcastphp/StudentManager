package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Student;

public interface StudentDao {
	//�����Ա��ѯѧ��
	public List<Student> selectStudentBySex(String sex);
	
	//�����������Ա����ģ����ѯ
	public List<Student> selectStudentByInfo(String info);
	
	//��ѯ����ѧ����Ϣ
	public List<Student> selectStudentAll();
	
	//��������ɾ��ѧ��
	public void deleteStudentBySid(String sid);
	
	//���ѧ��
	public int insertStudent(Student student);
	
	//ͳ��ѧ������
	public int selectCountStudent();
	
	//��ǰ��ҳ�����
	public List<Student> selectStudentByLimit(int startPage);
}
