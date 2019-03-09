package com.qfedu.domain;

import java.sql.Date;

public class User {
	private String nickname;
	private String password;
	private Date  registerTime;
	private String photo;
	private String email;
	private String linsence;
	private Boolean state;
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLinsence() {
		return linsence;
	}
	public void setLinsence(String linsence) {
		this.linsence = linsence;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", password=" + password + ", registerTime=" + registerTime + ",  photo=" + photo + ", email=" + email + ", linsence=" + linsence + ", state=" + state + "]";
	}
	
	
}
