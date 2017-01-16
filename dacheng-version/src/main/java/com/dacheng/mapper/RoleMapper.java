package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Role;

public interface RoleMapper {
	/**
	 * 保存角色信息
	 * @return 受影响行数
	 */
	public int saveRole(Role role) throws Exception;

	/**
	 * 根据角色编号删除角色信息
	 * @param Id
	 * @return 受影响的行数
	 */
	public int deleteRoleById(@Param("id") Long id) throws Exception;
	

	/**
	 * 更新role信息
	 * @return 受影响的行数
	 */
	public int updateRole(Role role) throws Exception;
	
	/**
	 * 根据角色编号查询角色信息
	 * @param ID 角色编号
	 * @return
	 */
	public Role findRoleById(@Param("id") Long id) throws Exception;

	/**
	 * 检查角色名称是否已经存在
	 * @return int
	 */
	public int checkRoleNameIsExist(@Param("roleName") String roleName) throws Exception;
	
	/**
	 * 查询角色列表
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public List<Role> findRoleList(Role role) throws Exception;
}