package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Data;

public interface DataDao {
	//上传资料
	public int insertData(Data data);
	
	//查找所有上传的资料
	public List<String> selectAllData();
}
