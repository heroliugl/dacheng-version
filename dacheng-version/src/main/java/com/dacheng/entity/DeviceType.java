package com.dacheng.entity;

import java.util.Date;
/**
 * 产品类型
 * @author Administrator
 *
 */
public class DeviceType {
	
	private Long typeId;   // 产品编号，自增

	private String typeName;    // 产品名称
	private String typeCode;  // 产品标识，产品key,自动生成，不可更改
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	private String status;    // 0:失效  1：生效（默认）
	
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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
		return "DeviceType [typeId=" + typeId + ", typeName=" + typeName + ", typeCode=" + typeCode + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", status=" + status + "]";
	}
	
}