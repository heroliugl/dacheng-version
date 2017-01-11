package com.dacheng.entity;

import java.util.Date;

public class ImeiAuthor {
	
	private String imei;
	private String authCode;  // 授权码
	private String authTime;  // 授权时间
	private String status; // 状态 0: 失效   1:生效
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	private String applyId;   // 申请编号
	
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAuthTime() {
		return authTime;
	}
	public void setAuthTime(String authTime) {
		this.authTime = authTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	@Override
	public String toString() {
		return "ImeiAuthor [imei=" + imei + ", authCode=" + authCode + ", authTime=" + authTime + ", status=" + status
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", applyId=" + applyId + "]";
	}
}