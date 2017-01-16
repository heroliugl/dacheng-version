package com.dacheng.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Device {
	
	private String deviceId;   // 设备编号，默认为mac地址
	private Long typeId;      // 产品编号
	private Long agencyId;    // 分销商编号
	private Date instockTime;  // 入库时间
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	private BigDecimal unitPrice;  // 单价
	private String batchId;    // 批次
	
	private DeviceType deviceType;
	
	private Agency agency;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}
	public Date getInstockTime() {
		return instockTime;
	}
	public void setInstockTime(Date instockTime) {
		this.instockTime = instockTime;
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
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getBatchId() {
		return batchId;
	}
	
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
	public DeviceType getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", typeId=" + typeId + ", agencyId=" + agencyId + ", instockTime="
				+ instockTime + ", createTime=" + createTime + ", updateTime=" + updateTime + ", unitPrice=" + unitPrice
				+ ", batchId=" + batchId + ", deviceType=" + deviceType + ", agency=" + agency + "]";
	}
}