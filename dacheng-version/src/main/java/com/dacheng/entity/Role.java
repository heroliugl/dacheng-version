package com.dacheng.entity;

import java.util.Date;

public class Role {
	private Long id;    // 角色编号
	private String roleName;   // 角色名称
	private String roleKey;    // 角色标识
	private String rolePower;    // 角色标识
	private String intro;       // 角色简介
	private String status;     // 角色状态  1：生效  0：失效
	private Date createTime; // 创建时间
	private Date updateTime; // 更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
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
	
	public String getRolePower() {
		return rolePower;
	}
	
	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleKey=" + roleKey + ", rolePower=" + rolePower
				+ ", intro=" + intro + ", status=" + status + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
}