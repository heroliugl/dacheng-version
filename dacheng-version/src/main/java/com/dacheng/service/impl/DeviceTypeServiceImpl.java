package com.dacheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dacheng.entity.DeviceType;
import com.dacheng.entity.Version;
import com.dacheng.entity.view.PageView;
import com.dacheng.mapper.DeviceTypeMapper;
import com.dacheng.mapper.VersionMapper;
import com.dacheng.service.DeviceTypeService;
import com.dacheng.service.VersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("deviceTypeService")
public class DeviceTypeServiceImpl implements DeviceTypeService {
	//用户Dao接口
	@Resource
	private DeviceTypeMapper deviceTypeMapper;

	@Override
	public int saveDeviceType(DeviceType deviceType) throws Exception {
		// TODO Auto-generated method stub
		return deviceTypeMapper.saveDeviceType(deviceType);
	}
	
	@Override
	public DeviceType findDeviceTypeById(Long typeId) throws Exception {
		// TODO Auto-generated method stub
		return deviceTypeMapper.findDeviceTypeById(typeId);
	}

	@Override
	public DeviceType findDeviceTypeByTypeCode(String typeCode) throws Exception {
		// TODO Auto-generated method stub
		return deviceTypeMapper.findDeviceTypeByTypeCode(typeCode);
	}
	
	@Override
	public int checkDeviceTypeNameIsExist(String typeName) throws Exception {
		// TODO Auto-generated method stub
		return deviceTypeMapper.checkDeviceTypeNameIsExist(typeName);
	}

	@Override
	public List<DeviceType> findDeviceTypeList(DeviceType deviceType) throws Exception {
		// TODO Auto-generated method stub
		List<DeviceType> list = new ArrayList<DeviceType>();
		list = deviceTypeMapper.findDeviceTypeList(deviceType);
		return list;
	}

	@Override
	public int deleteDeviceTypeById(Long typeId) throws Exception {
		// TODO Auto-generated method stub
		return deviceTypeMapper.deleteDeviceTypeById(typeId);
	}



	@Override
	public int updateDeviceType(DeviceType deviceType) throws Exception {
		// TODO Auto-generated method stub
		return deviceTypeMapper.updateDeviceType(deviceType);
	}


	@Override
	public PageView<DeviceType> findPage(Integer pageNo, Integer pageSize, DeviceType deviceType) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<DeviceType> list = this.deviceTypeMapper.findDeviceTypeList(deviceType);
	    //用PageInfo对结果进行包装
	    PageInfo<DeviceType> page = new PageInfo<DeviceType>(list);
	    PageView<DeviceType> pageView = new PageView<DeviceType>();
	    pageView.setPage(pageNo);
	    pageView.setPageSize(pageSize);
	    pageView.setRowCount((int) page.getTotal());
	    pageView.setRecords(page.getList());
		return pageView;
	}
	
	

	@Override
	public PageInfo<DeviceType> queryByPage(Integer pageNo, Integer pageSize, DeviceType deviceType) throws Exception {
		// TODO Auto-generated method stub
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo, pageSize);
	    List<DeviceType> list = this.deviceTypeMapper.findDeviceTypeList(deviceType);
	    //用PageInfo对结果进行包装
	    PageInfo<DeviceType> page = new PageInfo<DeviceType>(list);
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