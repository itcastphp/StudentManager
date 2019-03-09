package com.qfedu.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectUtil {
	public static <T> T selectOneObject(Connection connection,Class<T> cls,String sql,Object primeryKey) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setObject(1, primeryKey);
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				T t = cls.newInstance();
				Field[] fields = cls.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					field.setAccessible(true);
					field.set(t, resultSet.getObject(field.getName()));
				}
				return t;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static <T> List<T> selectList(Connection connection,Class<T> cls,String sql,Object... objects) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				prepareStatement.setObject(i+1, objects[i]);
			}
			ResultSet resultSet = prepareStatement.executeQuery();
			ArrayList<T> students = new ArrayList<T>();
			while(resultSet.next()) {
				T t = cls.newInstance();
				Field[] fields = cls.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					field.setAccessible(true);
					field.set(t, resultSet.getObject(field.getName()));
				}
				students.add(t);
			}
			
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> List<T> selectListPro(Connection connection,Class<T> cls,String sql,String info) {
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			String info2="%"+info+"%";
			prepareStatement.setString(1,info);
			prepareStatement.setString(2,info2);
			ResultSet resultSet = prepareStatement.executeQuery();
			ArrayList<T> students = new ArrayList<T>();
			while(resultSet.next()) {
				T t = cls.newInstance();
				Field[] fields = cls.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					field.setAccessible(true);
					field.set(t, resultSet.getObject(field.getName()));
				}
				students.add(t);
			}
			
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
