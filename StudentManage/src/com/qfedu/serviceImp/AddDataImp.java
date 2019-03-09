package com.qfedu.serviceImp;



import java.sql.Date;

import com.qfedu.dao.DataDao;
import com.qfedu.domain.Data;
import com.qfedu.service.AddData;

public class AddDataImp implements AddData{
	private DataDao dataDao;
	
	public DataDao getDataDao() {
		return dataDao;
	}

	public void setDataDao(DataDao dataDao) {
		this.dataDao = dataDao;
	}

	@Override
	public int UploadData(String username, String file) {
		Data data = new Data();
		data.setUsername(username);
		data.setRegisterTime(new Date(new java.util.Date().getTime()));
		data.setFile(file);
		return dataDao.insertData(data);
	}

}
