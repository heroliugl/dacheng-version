package com.dacheng.entity;

import java.util.Date;

public class ImeiApply {
	
	private String applyId;   // 申请编号
	private String imei;      // 手机imei码
	private String applyName;  // 申请人
	private Date applyTime;  // 申请时间
	private String applyType; // 授权类型 0: 无授权码   1: 有授权码
	private Integer applyNum; // 申请数量
	private Integer usedNum;  // 已使用数量
	private Date endTime;  // 申请到期时间
	private Date createTime;  // 创建时间
	private Date updateTime;  // 更新时间
	
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public Integer getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}
	public Integer getUsedNum() {
		return usedNum;
	}
	public void setUsedNum(Integer usedNum) {
		this.usedNum = usedNum;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
		return "ImeiApply [applyId=" + applyId + ", imei=" + imei + ", applyName=" + applyName + ", applyTime="
				+ applyTime + ", applyType=" + applyType + ", applyNum=" + applyNum + ", usedNum=" + usedNum
				+ ", endTime=" + endTime + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}