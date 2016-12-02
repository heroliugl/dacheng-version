package com.dacheng.push.entity;

public class UserProject {
	private int userprojectid;
	private int userid;
	private int projectid;
	private String mileage;
	private String createtime;
	public int getUserprojectid() {
		return userprojectid;
	}
	public void setUserprojectid(int userprojectid) {
		this.userprojectid = userprojectid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}