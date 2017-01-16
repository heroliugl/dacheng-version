package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.ImeiAuthor;
import com.dacheng.entity.Role;
import com.dacheng.entity.User;
import com.dacheng.entity.view.PageView;

public interface RoleService {
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
	public int deleteRoleById(@Param("imei") Long id) throws Exception;
	

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

	
	/**
	 * 角色分页
	 * @return PageView
	 */
	public PageView<Role> findPage(Integer pageNo, Integer pageSize,Role role) throws Exception;
	
	
}