package com.dacheng.push.entity.view;

public class RecordView {
	private int recordid;
	private int carid;
	private int projectid;
	private String projectname;
	private String englishname;
	private String recorddate;
	private String mileage;
	private String totalfee;
	private String workfee;
	private String recordphoto;
	private String smileage;   // 标准项目保养里程
	private String other;   // 标准项目保养里程
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
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
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
	public String getSmileage() {
		return smileage;
	}
	public void setSmileage(String smileage) {
		this.smileage = smileage;
	}
	public String getEnglishname() {
		return englishname;
	}
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
}