package com.qfedu.serviceImp;

import java.util.List;
import com.qfedu.daoImp.DataDaoImpl;
import com.qfedu.service.FindData;

public class FindDataImp implements FindData{
	private DataDaoImpl dataDaoImpl;
	
	public DataDaoImpl getDataDaoImpl() {
		return dataDaoImpl;
	}

	public void setDataDaoImpl(DataDaoImpl dataDaoImpl) {
		this.dataDaoImpl = dataDaoImpl;
	}

	//查找所有的上传的资料
	@Override
	public List<String> findAllData() {
		return dataDaoImpl.selectAllData();
	}
}
