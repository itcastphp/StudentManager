package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qfedu.dao.StudentDao;
import com.qfedu.domain.Student;
import com.qfedu.util.SelectUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class StudentDaoImpl implements StudentDao{
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	//根据性别查询学生
	@Override
	public List<Student> selectStudentBySex(String sex) {
		String sql="select*from student where ssex=?";
		QueryRunner queryRunner = new QueryRunner();
		List<Student> studends=null;
		try {
			studends=queryRunner.query(connection, sql, new BeanListHandler<Student>(Student.class), sex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studends;
	}
	
	//根据姓名和性别进行模糊查询
	@Override
	public List<Student> selectStudentByInfo(String info) {
		String sql="select*from student where ssex=? or sname like ?";
		QueryRunner queryRunner = new QueryRunner();
		String info2=info+"";
		List<Student> students=null;
		try {
			students=queryRunner.query(connection, sql, new BeanListHandler<Student>(Student.class), info,info2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	//查询所有学生信息
	@Override
	public List<Student> selectStudentAll() {
		String sql = "select * from student";
		QueryRunner queryRunner = new QueryRunner();
		List<Student> students=null;
		try {
			students=queryRunner.query(connection, sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	//根据主键删除学生
	@Override
	public void deleteStudentBySid(String sid) {
		String sql = "delete from student where sid = ?";
		QueryRunner queryRunner = new QueryRunner();
		try {
			int update = queryRunner.update(connection, sql, sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//添加学生
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student(sid,sname,sage,ssex) values(?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner();
		int row=0;
		try {
			row=queryRunner.update(connection, sql, student.getSid(),student.getSname(),student.getSage(),student.getSsex());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int selectCountStudent() {
		String sql="select count(*) from student";
		QueryRunner queryRunner = new QueryRunner();
		int result=0;
		try {
			result = queryRunner.query(connection, sql, new ScalarHandler<Long>()).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> selectStudentByLimit(int startPage) {
		String sql="select*from student limit ?,4 ";
		QueryRunner queryRunner = new QueryRunner();
		int m=(startPage-1)*3;
		List<Student> students=null;
		try {
			students = queryRunner.query(connection, sql,new BeanListHandler<Student>(Student.class),m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
}
