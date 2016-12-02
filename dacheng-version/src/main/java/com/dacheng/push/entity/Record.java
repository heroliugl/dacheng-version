package com.dacheng.push.entity;

public class Record {
	private int recordid;
	private int carid;
	private Project project;
	private String recorddate;
	private String mileage;
	private String totalfee;
	private String workfee;
	private String recordphoto;
	private String other;
	public int getRecordid() {
		return recordid;
	}
	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getRecorddate() {
		return recorddate;
	}
	public void setRecorddate(String recorddate) {
		this.recorddate = recorddate;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(String totalfee) {
		this.totalfee = totalfee;
	}
	public String getWorkfee() {
		return workfee;
	}
	public void setWorkfee(String workfee) {
		this.workfee = workfee;
	}
	public String getRecordphoto() {
		return recordphoto;
	}
	public void setRecordphoto(String recordphoto) {
		this.recordphoto = recordphoto;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
}