package com.dacheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.User;

public interface UserMapper {
	/**
	 * 保存用户信息
	 * @return 受影响行数
	 */
	public int saveUser(User user) throws Exception;

	
	/**
	 * 根据登录名查询用户
	 * @param loginName 登录名
	 * @return
	 */
	public User findUserById(@Param("id") Long id) throws Exception;
	
	/**
	 * 根据登录名和密码查询用户
	 * @param loginName 登录名
	 * @param password 密码
	 * @return
	 */
	public User findUserByLoginNameAndPassword(@Param("loginName") String loginName,
			@Param("password") String password) throws Exception;
	
	/**
	 * 根据登录名查询用户
	 * @param loginName 登录名
	 * @return
	 */
	public User findUserByLoginName(@Param("loginName") String loginName) throws Exception;
	
	/**
	 * 查询用户列表
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserList(User user) throws Exception;
}