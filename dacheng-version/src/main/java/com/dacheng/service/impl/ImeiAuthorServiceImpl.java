package com.dacheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.ImeiAuthor;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.ImeiAuthorMapper;
import com.dacheng.service.ImeiAuthorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("imeiAuthorService")
public class ImeiAuthorServiceImpl implements ImeiAuthorService {
	//用户Dao接口
	@Resource
	private ImeiAuthorMapper imeiAuthorMapper;


	@Override
	public int saveImeiAuthor(ImeiAuthor imeiAuthor) throws Exception {
		// TODO Auto-generated method stub
		return imeiAuthorMapper.saveImeiAuthor(imeiAuthor);
	}

	@Override
	public int deleteImeiAuthorByImei(String imei) throws Exception {
		// TODO Auto-generated method stub
		return imeiAuthorMapper.deleteImeiAuthorByImei(imei);
	}

	@Override
	public int updateImeiAuthor(ImeiAuthor imeiAuthor) throws Exception {
		// TODO Auto-generated method stub
		return imeiAuthorMapper.updateImeiAuthor(imeiAuthor);
	}

	@Override
	public ImeiAuthor findImeiAuthorByImei(String imei) throws Exception {
		// TODO Auto-generated method stub
		return imeiAuthorMapper.findImeiAuthorByImei(imei);
	}

	@Override
	public List<ImeiAuthor> findImeiAuthorList(ImeiAuthor imeiAuthor) throws Exception {
		// TODO Auto-generated method stub
		List<ImeiAuthor> list = new ArrayList<ImeiAuthor>();
		list = imeiAuthorMapper.findImeiAuthorList(imeiAuthor);
		return list;
	}

	@Override
	public PageView<ImeiAuthor> findPage(Integer pageNo, Integer pageSize, ImeiAuthor imeiAuthor) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<ImeiAuthor> list = this.imeiAuthorMapper.findImeiAuthorList(imeiAuthor);
	    //用PageInfo对结果进行包装
	    PageInfo<ImeiAuthor> page = new PageInfo<ImeiAuthor>(list);
	    PageView<ImeiAuthor> pageView = new PageView<ImeiAuthor>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}
	
	

	@Override
	public PageInfo<ImeiAuthor> queryByPage(Integer pageNo, Integer pageSize, ImeiAuthor imeiAuthor) throws Exception {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<ImeiAuthor> list = this.imeiAuthorMapper.findImeiAuthorList(imeiAuthor);
	    //用PageInfo对结果进行包装
	    PageInfo<ImeiAuthor> page = new PageInfo<ImeiAuthor>(list);
	    //测试PageInfo全部属性
/*	    System.out.println(page.getPageNum());
	    System.out.println(page.getPageSize());
	    System.out.println(page.getStartRow());
	    System.out.println(page.getEndRow());
	    System.out.println(page.getTotal());
	    System.out.println(page.getPages());
	    System.out.println(page.getFirstPage());
	    System.out.println(page.getLastPage());
	    System.out.println(page.isHasPreviousPage());
	    System.out.println(page.isHasNextPage());*/
		return page;
	}


}