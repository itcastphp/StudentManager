package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Page;
import com.qfedu.domain.Student;

public interface FindStudent {
	//�����Ա��ѯѧ��
	public List<Student> getStudentBySsex(String sex);
	
	//�����������Ա����ģ����ѯ
	public List<Student> getStudentsByInfo(String info);
	
	//��ѯ����ѧ����Ϣ
	public List<Student> getStudentAll();
	
	//��ҳ��ѯѧ������Ϣ
	public Page buildData(int startPage);
}
