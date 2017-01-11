package com.dacheng.service;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.ImeiAuthor;
import com.dacheng.entity.User;
import com.dacheng.entity.view.PageView;

public interface UserService {
	/**
	 * 保存用户信息
	 * @return 受影响行数
	 */
	public int saveUser(@Param("user") User user) throws Exception;

	
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
	 * 根据授权imei查询授权imei信息
	 * @return 授权imei信息
	 */
	public PageView<User> findPage(Integer pageNo, Integer pageSize,User user) throws Exception;
	
	
}