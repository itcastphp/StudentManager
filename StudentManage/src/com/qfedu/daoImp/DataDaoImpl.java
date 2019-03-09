package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.qfedu.dao.DataDao;
import com.qfedu.domain.Data;

public class DataDaoImpl implements DataDao{
	private Connection connection;
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	//资料上传
	@Override
	public int insertData(Data data) {
		String sql="insert into dataupload(username,file,uploadTime) values(?,?,?)";
		QueryRunner queryRunner = new QueryRunner();
		int row=0;
		try {
			row = queryRunner.update(connection, sql,data.getUsername(),data.getFile(),data.getRegisterTime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	//查找所有上传的资料
	@Override
	public List<String> selectAllData() {
		String sql="select file from dataupload";
		QueryRunner queryRunner = new QueryRunner();
		List<String> files=null;
		try {
			files = queryRunner.query(connection, sql, new ColumnListHandler<String>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return files;
	}

}
