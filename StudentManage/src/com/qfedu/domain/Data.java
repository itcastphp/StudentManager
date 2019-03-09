 package com.qfedu.domain;

import java.sql.Date;

public class Data {
	private String username;
	private String file;
	private Date  registerTime;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "Data [username=" + username + ", file=" + file + ", registerTime=" + registerTime + "]";
	}
	
	
}
