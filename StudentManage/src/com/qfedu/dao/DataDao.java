package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Data;

public interface DataDao {
	//�ϴ�����
	public int insertData(Data data);
	
	//���������ϴ�������
	public List<String> selectAllData();
}
