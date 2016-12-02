package com.dacheng.push.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dacheng.push.entity.User;
import com.dacheng.push.mapper.UserMapper;
import com.dacheng.push.service.UserService;

@Service("userBiz")
public class UserServiceImpl implements UserService {
	//用户Dao接口
	@Resource
	private UserMapper userMapper;
		
	/**
	 * 查询所有用户信息
	 * @return 用户集合
	 */
	public List<User> findUsers() throws Exception {
		//调用《UserMapper》的《查询所有用户信息》方法
		List<User> users = this.userMapper.queryUsers();
		return users;
	}

	/**
	 * 保存用户信息
	 * @return 受影响行数
	 */
	public int saveUser(@Param("user") User user) throws Exception {
		//调用《UserMapper》的《保存用户信息》方法
		return this.userMapper.insertUser(user);
	}
	public int updateImeiUserToRegisterUser(User user)  throws Exception {
		return this.userMapper.updateImeiUserToRegisterUser(user);
	}
	/**
	 * 根据登录名和密码查询用户
	 * @param loginName 登录名
	 * @param password 密码
	 * @return
	 */
	public User findUserByLoginnameAndPassword(@Param("loginname") String loginname,
			@Param("password") String password) throws Exception {
		//调用《UserMapper》的《根据登录名和密码查询用户》方法
		User user = this.userMapper.queryUserByLoginnameAndPassword(loginname, password);
		return user;
	}
	
	/**
	 * 根据登录名查询用户
	 * @param loginName 登录名
	 * @return
	 */
	public User findUserByLoginname(@Param("loginname") String loginname) throws Exception {
		//调用《UserMapper》的《根据登录名查询用户》方法
		User user = this.userMapper.queryUserByLoginname(loginname);
		return user;
	}
	
	/**
	 * 根据用户ID更新用户头像地址
	 * @param userid 用户ID
	 * @param headurl 头像路径
	 * @return
	 */
	public int modifyUserHeadurlByUserid(@Param("userid") int userid,
			@Param("headurl") String headurl) throws Exception {
		//调用《UserMapper》的《根据用户ID更新用户头像地址》方法
		int rowNum = this.userMapper.updateUserHeadurlByUserid(userid, headurl);
		return rowNum;
	}
	
	
	/**
	 * 根据用户ID查询用户
	 * @param userid 用户ID
	 * @return
	 */
	public User findUserByUserid(@Param("userid") int userid) throws Exception {
		//调用《UserMapper》的《根据用户ID查询用户》方法
		User user = this.userMapper.queryUserByUserid(userid);
		return user;
	}
	
	/**
	 * 根据用户ID更新油价
	 * @param userid 用户ID
	 * @param fuelprice 油价
	 * @return
	 */
	public int modifyFuelpriceByUserid(@Param("loginname") String loginname,
			@Param("fuelprice") String fuelprice) throws Exception {
		//调用《UserMapper》的《根据用户ID更新油价》方法
		int rowNum = this.userMapper.updateFuelpriceByUserid(loginname, fuelprice);
		return rowNum;
	}
	
	/**
	 * 根据用户登录名更新密码
	 * @param loginname 登录名
	 * @param newpassword 密码
	 * @return
	 */
	public int modifyPasswordByLoginname(@Param("loginname") String loginname,
			@Param("newpassword") String newpassword) throws Exception {
		//调用《UserMapper》的《根据用户登录名更新密码》方法
		int rowNum = this.userMapper.updatePasswordByLoginname(loginname, newpassword);
		return rowNum;
	}
	public int createDefaultUser(User user) throws Exception {
		return this.userMapper.insertUser(user);
	}

	/**
	 * 根据用户登录名设置邮箱
	 * @param loginname 登录名
	 * @param email 邮箱地址
	 * @return
	 * */
	public int settingEmail(@Param("loginname")String loginname,@Param("email") String email) throws Exception {
		//调用《UserMapper》的《根据用户登录名更新email》方法
		 int rowNum=this.userMapper.updateEmailByLoginname(loginname, email);
		 return rowNum;
	}
	public User createUserIfNoExist(String loginname) throws Exception {
		User user = this.findUserByLoginname(loginname);
		if(user==null||user.getUserid()<=0){//用户不存在 创建用户
			user = new User();
			user.setLoginname(loginname);
			user.setPassword("123456");
			user.setSex(1);
			user.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault()).format(new Date()));
			user.setStatus(1);
			user.setIsRegisterUser(0);
			int createUserResult = this.createDefaultUser(user);
			if(createUserResult<=0){
				return null;
			}
		}
		return user;
	}

}