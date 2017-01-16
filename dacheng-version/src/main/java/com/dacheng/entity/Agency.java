package com.dacheng.entity;

import java.util.Date;
/**
 * 分销商
 * @author Administrator
 *
 */
public class Agency {
	
	private Long agencyId;        // 分销商编号（必填）
	private String agencyCode;    // 分销商识别码
	private String agencyName;    // 分销商名称（必填）
	private String contacts;      // 分销商联系人
	private String mobilePhone;   // 手机号码
	private String telePhone;     // 固定电话
	private String email;         // 电子邮箱
	private String status;        // 状态  0：失效  1：生效（默认）
	private String remarks;       // 备注
	private Date createTime;      // 创建时间
	private Date updateTime;      // 更新时间
	
	public Long getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	
	@Override
	public String toString() {
		return "Agency [agencyId=" + agencyId + ", agencyCode=" + agencyCode + ", agencyName=" + agencyName
				+ ", contacts=" + contacts + ", mobilePhone=" + mobilePhone + ", telePhone=" + telePhone + ", email="
				+ email + ", status=" + status + ", remarks=" + remarks + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
}