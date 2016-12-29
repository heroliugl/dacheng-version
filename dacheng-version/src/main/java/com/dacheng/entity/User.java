package com.dacheng.entity;

public class User {
	private int userid;
	private String loginname;
	private String nickname;
	private String email;
	private String password;
	private String headurl;
	private int sex;
	private String createtime;
	private String fuelprice;
	private int status;
	private int isRegisterUser;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getFuelprice() {
		return fuelprice;
	}
	public void setFuelprice(String fuelprice) {
		this.fuelprice = fuelprice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsRegisterUser() {
		return isRegisterUser;
	}
	public void setIsRegisterUser(int isRegisterUser) {
		this.isRegisterUser = isRegisterUser;
	}
}