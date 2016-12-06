package com.dacheng.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.VersionMapper;
import com.dacheng.service.VersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("versionService")
public class VersionServiceImpl implements VersionService {
	//用户Dao接口
	@Resource
	private VersionMapper versionMapper;

	@Override
	public int saveVersion(Version version) throws Exception {
		// TODO Auto-generated method stub
		int rowNum = this.versionMapper.saveVersion(version);
		return rowNum;
	}

	@Override
	public Version findVersionById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Version version = versionMapper.findVersionById(id);
		return version;
	}

	@Override
	public int deleteVersionById(Long id) throws Exception {
		// TODO Auto-generated method stub
		int rowNum = this.versionMapper.deleteVersionById(id);
		return rowNum;
	}
	
	@Override
	public int UpdateVersion(Version version) throws Exception {
		// TODO Auto-generated method stub
		
		int rowNum = this.versionMapper.UpdateVersion(version);
		return rowNum;
	}

	@Override
	public PageView<Version> findPage(Integer pageNo, Integer pageSize,Version version) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<Version> list = this.versionMapper.findList(version);
	    //用PageInfo对结果进行包装
	    PageInfo<Version> page = new PageInfo<Version>(list);
	    PageView<Version> pageView = new PageView<Version>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}
	
	

	@Override
	public PageInfo<Version> queryByPage(Integer pageNo, Integer pageSize,Version version) throws Exception {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<Version> list = this.versionMapper.findList(version);
	    //用PageInfo对结果进行包装
	    PageInfo<Version> page = new PageInfo<Version>(list);
	    //测试PageInfo全部属性
	    System.out.println(page.getPageNum());
	    System.out.println(page.getPageSize());
	    System.out.println(page.getStartRow());
	    System.out.println(page.getEndRow());
	    System.out.println(page.getTotal());
	    System.out.println(page.getPages());
	    System.out.println(page.getFirstPage());
	    System.out.println(page.getLastPage());
	    System.out.println(page.isHasPreviousPage());
	    System.out.println(page.isHasNextPage());
		return page;
	}
	
}