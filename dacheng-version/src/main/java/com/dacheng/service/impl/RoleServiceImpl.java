package com.dacheng.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.Role;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.RoleMapper;
import com.dacheng.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	//用户Dao接口
	@Resource
	private RoleMapper roleMapper;

	@Override
	public int saveRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.saveRole(role);
	}

	@Override
	public int deleteRoleById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.deleteRoleById(id);
	}
	
	@Override
	public int updateRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.updateRole(role);
	}

	@Override
	public Role findRoleById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.findRoleById(id);
	}

	@Override
	public int checkRoleNameIsExist(String roleName) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.checkRoleNameIsExist(roleName);
	}

	@Override
	public List<Role> findRoleList(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.findRoleList(role);
	}
	
	@Override
	public PageView<Role> findPage(Integer pageNo, Integer pageSize, Role role) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<Role> list = this.roleMapper.findRoleList(role);
	    //用PageInfo对结果进行包装
	    PageInfo<Role> page = new PageInfo<Role>(list);
	    PageView<Role> pageView = new PageView<Role>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}

}