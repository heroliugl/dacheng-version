package com.dacheng.entity;

import java.util.Date;

public class VersionLog {
	
	private Long versionId; // 版本编号
	private String lang;  // 版本说明语言类型
	private String vlog;   // 版本{升级}说明
	private String status; // 状态 0:失效   1:生效
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getVlog() {
		return vlog;
	}
	public void setVlog(String vlog) {
		this.vlog = vlog;
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
	
	@Override
	public String toString() {
		return "VersionLog [versionId=" + versionId + ", lang=" + lang + ", vlog=" + vlog + ", status=" + status
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}