package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.ColumnHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.qfedu.dao.UserDao;
import com.qfedu.domain.User;
import com.qfedu.util.UuidUtil;
public class UserDaoImpl implements UserDao{
	private Connection connection;
	
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	//注册用户
	@Override
	public int insertUser(User user) {
		String sql="insert into user(nickname,password,registerTime,photo,email,linsence) values(?,md5(?),?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner();
		int row=0;
		try {
			row=queryRunner.update(connection, sql, user.getNickname(),user.getPassword(),user.getRegisterTime(),user.getPhoto(),user.getEmail(),user.getLinsence());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	//用户登录
	@Override
	public Boolean selectUser(String nickname, String password) {
		String sql="select*from user where nickname=? and password=md5(?)";
		QueryRunner queryRunner = new QueryRunner();
		try {
			User user = queryRunner.query(connection, sql, new  BeanHandler<User>(User.class), nickname,password);
			if(user!=null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	//查找用户头像
	@Override
	public String selectUserPhoto(String nickname, String password) {
		String sql="select photo from user where nickname=? and password=md5(?)";
		QueryRunner queryRunner = new QueryRunner();
		List<String> s =null;
		try {
			s = queryRunner.query(connection, sql,new ColumnListHandler<String>(), nickname,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Iterator<String> iterator = s.iterator();
		String str = null;
		while(iterator.hasNext()) {
			str = iterator.next();
		}
		return str;
	}
	
	//激活用户
	@Override
	public void updateUser(String linsenceCode) {
		// TODO Auto-generated method stub
		
	}
}
