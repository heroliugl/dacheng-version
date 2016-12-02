package com.dacheng.push.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.dacheng.push.entity.User;

public interface UserService {
	/**
	 * 查询所有用户信息
	 * @return 用户集合
	 */
	public List<User> findUsers() throws Exception;

	/**
	 * 保存用户信息
	 * @return 受影响行数
	 */
	public int saveUser(@Param("user") User user) throws Exception;
	/**
	 * 更改imei用户为注册用户
	 * @param user
	 * @return 
	 * @throws Exception 
	 */
	public int updateImeiUserToRegisterUser(User user) throws Exception;
	/**
	 * 根据登录名和密码查询用户
	 * @param loginName 登录名
	 * @param password 密码
	 * @return
	 */
	public User findUserByLoginnameAndPassword(@Param("loginname") String loginname,
			@Param("password") String password) throws Exception;
	
	/**
	 * 根据登录名查询用户
	 * @param loginName 登录名
	 * @return
	 */
	public User findUserByLoginname(@Param("loginname") String loginname) throws Exception;
	
	/**
	 * 根据用户ID更新用户头像地址
	 * @param userid 用户ID
	 * @param headurl 头像路径
	 * @return
	 */
	public int modifyUserHeadurlByUserid(@Param("userid") int userid,
			@Param("headurl") String headurl) throws Exception;
	
	/**
	 * 根据用户ID查询用户
	 * @param userid 用户ID
	 * @return
	 */
	public User findUserByUserid(@Param("userid") int userid) throws Exception;
	
	
	/**
	 * 根据用户ID更新油价
	 * @param loginname 
	 * @param fuelprice 油价
	 * @return
	 */
	public int modifyFuelpriceByUserid(@Param("loginname") String loginname,
			@Param("fuelprice") String fuelprice) throws Exception;
	
	/**
	 * 根据用户登录名更新密码
	 * @param loginname 登录名
	 * @param newpassword 密码
	 * @return
	 */
	public int modifyPasswordByLoginname(@Param("loginname") String loginname,
			@Param("newpassword") String newpassword) throws Exception;

	/**
	 * 创建一个默认用户 用户名是imei
	 * @param user
	 * @return 
	 * @throws Exception
	 */
	public int createDefaultUser(User user)  throws Exception;
	
	/**
	 * 根据用户登录名设置邮箱
	 * @param loginname 登录名
	 * @param email 邮箱地址
	 * @return
	 * */
	public int settingEmail(@Param("loginname") String loginname,
			@Param("email") String email) throws Exception;
	
	public User createUserIfNoExist(String loginname) throws Exception;
	
}