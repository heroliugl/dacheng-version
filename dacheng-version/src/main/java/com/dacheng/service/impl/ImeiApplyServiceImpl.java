package com.dacheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.ImeiApply;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.ImeiApplyMapper;
import com.dacheng.service.ImeiApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("imeiApplyService")
public class ImeiApplyServiceImpl implements ImeiApplyService {
	//用户Dao接口
	@Resource
	private ImeiApplyMapper imeiApplyMapper;

	@Override
	public int deleteImeiApplyByImei(String imei) throws Exception {
		// TODO Auto-generated method stub
		return imeiApplyMapper.deleteImeiApplyByImei(imei);
	}
	
	@Override
	public int deleteImeiApplyByApplyId(String applyId) throws Exception {
		// TODO Auto-generated method stub
		return imeiApplyMapper.deleteImeiApplyByApplyId(applyId);
	}
	
	@Override
	public ImeiApply findImeiApplyByApplyId(String applyId) throws Exception {
		// TODO Auto-generated method stub
		return imeiApplyMapper.findImeiApplyByApplyId(applyId);
	}

	@Override
	public List<ImeiApply> findImeiApplyList(ImeiApply imeiApply) throws Exception {
		// TODO Auto-generated method stub
		List<ImeiApply> list = new ArrayList<ImeiApply>();
		list = imeiApplyMapper.findImeiApplyList(imeiApply);
		return list;
	}

	@Override
	public PageView<ImeiApply> findPage(Integer pageNo, Integer pageSize, ImeiApply imeiApply) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<ImeiApply> list = this.imeiApplyMapper.findImeiApplyList(imeiApply);
	    //用PageInfo对结果进行包装
	    PageInfo<ImeiApply> page = new PageInfo<ImeiApply>(list);
	    PageView<ImeiApply> pageView = new PageView<ImeiApply>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}
	
	

	@Override
	public PageInfo<ImeiApply> queryByPage(Integer pageNo, Integer pageSize, ImeiApply imeiApply) throws Exception {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<ImeiApply> list = this.imeiApplyMapper.findImeiApplyList(imeiApply);
	    //用PageInfo对结果进行包装
	    PageInfo<ImeiApply> page = new PageInfo<ImeiApply>(list);
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