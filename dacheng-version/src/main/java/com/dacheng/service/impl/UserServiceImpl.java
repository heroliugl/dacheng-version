package com.dacheng.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dacheng.entity.User;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.UserMapper;
import com.dacheng.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("userService")
public class UserServiceImpl implements UserService {
	//用户Dao接口
	@Resource
	private UserMapper userMapper;
		
	/**
	 * 保存用户信息
	 * @return 受影响行数
	 */
	public int saveUser(User user) throws Exception {
		//调用《UserMapper》的《保存用户信息》方法
		return this.userMapper.saveUser(user);
	}
	
	/**
	 * 根据用户ID查询用户
	 * @param userid 用户ID
	 * @return
	 */
	public User findUserById(@Param("id") Long id) throws Exception {
		//调用《UserMapper》的《根据用户ID查询用户》方法
		User user = this.userMapper.findUserById(id);
		return user;
	}
	
	/**
	 * 根据登录名和密码查询用户
	 * @param loginName 登录名
	 * @param password 密码
	 * @return
	 */
	public User findUserByLoginNameAndPassword(@Param("loginName") String loginName,
			@Param("password") String password) throws Exception {
		//调用《UserMapper》的《根据登录名和密码查询用户》方法
		User user = this.userMapper.findUserByLoginNameAndPassword(loginName, password);
		return user;
	}
	
	/**
	 * 根据登录名查询用户
	 * @param loginName 登录名
	 * @return
	 */
	public User findUserByLoginName(@Param("loginName") String loginName) throws Exception {
		//调用《UserMapper》的《根据登录名查询用户》方法
		User user = this.userMapper.findUserByLoginName(loginName);
		return user;
	}
	
	@Override
	public PageView<User> findPage(Integer pageNo, Integer pageSize, User user) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<User> list = this.userMapper.findUserList(user);
	    //用PageInfo对结果进行包装
	    PageInfo<User> page = new PageInfo<User>(list);
	    PageView<User> pageView = new PageView<User>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}

}