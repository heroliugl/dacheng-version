package com.dacheng.entity;

import java.util.Date;
/**
 * 盗版设备
 * @author Administrator
 *
 */
public class PiracyDevice {
	
	private String deviceId;   // 设备编号，默认为mac地址
	private String typeCode;      // 产品key
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	private String status;    // 状态
	
	private DeviceType deviceType;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
	
	public DeviceType getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	@Override
	public String toString() {
		return "PiracyDevice [deviceId=" + deviceId + ", typeCode=" + typeCode + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", status=" + status + "]";
	}
	
}