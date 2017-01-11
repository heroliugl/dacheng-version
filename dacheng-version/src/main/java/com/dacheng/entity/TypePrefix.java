package com.dacheng.entity;

import java.util.Date;
/**
 * 产品类型相关的蓝牙名称
 * @author Administrator
 *
 */
public class TypePrefix {
	
	private Long typeId;   // 产品编号
	private String typePrefix;    // 蓝牙名称（前缀或者蓝牙部分名称）
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	private String status;    // 0:失效  1：生效（默认）
	
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getTypePrefix() {
		return typePrefix;
	}
	public void setTypePrefix(String typePrefix) {
		this.typePrefix = typePrefix;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TypePrefix [typeId=" + typeId + ", typePrefix=" + typePrefix + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", status=" + status + "]";
	}
}