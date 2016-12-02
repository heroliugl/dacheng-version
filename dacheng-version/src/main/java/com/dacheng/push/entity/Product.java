package com.dacheng.push.entity;

public class Product {
	private Integer productId;    // 用户编号
	private String productName;    // 角色编号
	private String createTime; // 创建时间
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}