package com.dacheng.entity;

public class Role {
	private Long roleId;    // 角色编号
	private String roleName;   // 角色名称
	private String roleKey;    // 角色标识
	private String createTime; // 创建时间
	private String description;// 角色介绍
	private String status;     // 角色状态  1：生效  0：失效
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleKey=" + roleKey + ", createTime="
				+ createTime + ", description=" + description + ", status=" + status + "]";
	}
	
}