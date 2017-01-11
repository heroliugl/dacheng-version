package com.dacheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.TypePrefix;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.TypePrefixMapper;
import com.dacheng.service.TypePrefixService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("typePrefixService")
public class TypePrefixServiceImpl implements TypePrefixService {
	//用户Dao接口
	@Resource
	private TypePrefixMapper typePrefixMapper;

	@Override
	public int saveTypePrefix(TypePrefix deviceType) throws Exception {
		return typePrefixMapper.saveTypePrefix(deviceType);
	}
	
	@Override
	public int deleteTypePrefixByTypeId(Long typeId) throws Exception {
		return typePrefixMapper.deleteTypePrefixByTypeId(typeId);
	}
	
	@Override
	public int deleteTypePrefixByTypeIdAndPrefix(Long typeId, String typePrefix) throws Exception {
		return typePrefixMapper.deleteTypePrefixByTypeIdAndPrefix(typeId, typePrefix);
	}

	@Override
	public int updateTypePrefix(TypePrefix typePrefix) throws Exception {
		return typePrefixMapper.updateTypePrefix(typePrefix);
	}

	@Override
	public TypePrefix findTypePrefixByTypeIdAndPrefix(Long typeId, String typePrefix) throws Exception {
		return typePrefixMapper.findTypePrefixByTypeIdAndPrefix(typeId, typePrefix);
	}

	@Override
	public TypePrefix findTypePrefixByPrefix(String typePrefix) throws Exception {
		return typePrefixMapper.findTypePrefixByPrefix(typePrefix);
	}

	@Override
	public int checkTypePrefixIsExist(String typePrefix) throws Exception {
		return typePrefixMapper.checkTypePrefixIsExist(typePrefix);
	}

	@Override
	public List<TypePrefix> findTypePrefixList(TypePrefix typePrefix) throws Exception {
		List<TypePrefix> list = new ArrayList<TypePrefix>();
		list = typePrefixMapper.findTypePrefixList(typePrefix);
		return list;
	}

	@Override
	public PageView<TypePrefix> findPage(Integer pageNo, Integer pageSize, TypePrefix deviceType) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<TypePrefix> list = this.typePrefixMapper.findTypePrefixList(deviceType);
	    //用PageInfo对结果进行包装
	    PageInfo<TypePrefix> page = new PageInfo<TypePrefix>(list);
	    PageView<TypePrefix> pageView = new PageView<TypePrefix>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}
	
	@Override
	public PageInfo<TypePrefix> queryByPage(Integer pageNo, Integer pageSize, TypePrefix deviceType) throws Exception {
		
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<TypePrefix> list = this.typePrefixMapper.findTypePrefixList(deviceType);
	    //用PageInfo对结果进行包装
	    PageInfo<TypePrefix> page = new PageInfo<TypePrefix>(list);
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